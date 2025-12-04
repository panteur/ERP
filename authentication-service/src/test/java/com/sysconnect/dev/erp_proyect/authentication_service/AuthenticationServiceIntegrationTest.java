package com.sysconnect.dev.erp_proyect.authentication_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateAppUserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.feignclients.StatusFeignClient;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Transactional // Para que cada test se ejecute en una transacción y se revierta
public class AuthenticationServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AppUserRepository appUserRepository; // Usamos el repositorio real

    @Autowired
    private RoleRepository roleRepository; // Usamos el repositorio real para roles

    @MockBean
    private EmailService emailService; // Mockeamos el envío de correos

    @MockBean
    private StatusFeignClient statusFeignClient; // Mockeamos el cliente Feign

    // Mocks necesarios para que el contexto de seguridad OAuth2 se cargue sin errores
    // ya que no estamos probando la autenticación OAuth2 en este test específico
    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;
    @MockBean
    private OAuth2AuthorizedClientRepository authorizedClientRepository;

    private Role userRole;

    @BeforeEach
    void setUp() {
        // Asegurarse de que el rol exista en la base de datos de prueba
        // Solo lo creamos si no existe para evitar duplicados si se ejecuta varias veces
        Optional<Role> existingRole = roleRepository.findByRole("ROLE_USER");
        if (existingRole.isEmpty()) {
            userRole = Role.builder().role("ROLE_USER").build();
            roleRepository.save(userRole);
        } else {
            userRole = existingRole.get();
        }
    }

    @Test
    void whenCreateUser_thenUserIsSavedAndVerificationEmailSent() throws Exception {
        // Arrange
        String username = "integrationUser";
        String email = "integration@example.com";
        String password = "securePassword";
        String roleName = "ROLE_USER";

        CreateAppUserDto createDto = new CreateAppUserDto(username, password, email, List.of(roleName));
        MessageDto expectedMessage = new MessageDto("Usuario " + username + " guardado. Se ha enviado un correo de verificación.");

        // Act
        mockMvc.perform(post("/auth/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated()) // Esperamos 201 Created
                .andExpect(content().json(objectMapper.writeValueAsString(expectedMessage)));

        // Assert: Verificaciones adicionales
        // 1. Verificar que el usuario fue guardado en la base de datos real
        Optional<AppUser> savedUserOptional = appUserRepository.findByUsername(username);
        assertThat(savedUserOptional).isPresent();
        AppUser savedUser = savedUserOptional.get();
        assertThat(savedUser.getUsername()).isEqualTo(username);
        assertThat(savedUser.getEmail()).isEqualTo(email);
        assertThat(savedUser.getPassword()).isNotNull(); // La contraseña debe estar hasheada
        assertThat(savedUser.isEmailVerified()).isFalse(); // Por defecto, no verificado
        assertThat(savedUser.getVerificationToken()).isNotNull(); // Debe tener un token
        assertThat(savedUser.getStatusId()).isEqualTo(2L); // El valor por defecto

        // 2. Verificar que el correo de verificación fue enviado
        verify(emailService, times(1)).sendEmail(
                eq(email),
                eq("Verifica tu cuenta"),
                anyString() // El cuerpo del correo contendrá el enlace con el token
        );
    }
}
