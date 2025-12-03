package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysconnect.dev.erp_proyect.authentication_service.config.AuthorizationSecurityConfig;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import com.sysconnect.dev.erp_proyect.authentication_service.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AuthController.class, properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Import(AuthorizationSecurityConfig.class) // Importa tu configuración de seguridad
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos a JSON

    // Mocks necesarios para AuthorizationSecurityConfig
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private ClientService clientService;


    @Test
    void whenListAllUsers_thenReturnListOfUserDto() throws Exception {
        // Arrange: Preparamos los datos de prueba y el comportamiento del mock
        UserDto userDto1 = UserDto.builder()
                .username("user1")
                .email("user1@example.com")
                .rut("11111111-1")
                .statusName("Activo")
                .build();
        UserDto userDto2 = UserDto.builder()
                .username("user2")
                .email("user2@example.com")
                .rut("22222222-2")
                .statusName("Inactivo")
                .build();
        List<UserDto> userDtoList = List.of(userDto1, userDto2);

        // Cuando se llame a appUserService.findAllUsersWithStatus(), devuelve nuestra lista de prueba
        when(appUserService.findAllUsersWithStatus()).thenReturn(userDtoList);

        // Act & Assert: Realizamos la petición y verificamos la respuesta
        mockMvc.perform(get("/auth/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Esperamos un código de estado 200 OK
                .andExpect(content().json(objectMapper.writeValueAsString(userDtoList))); // Verificamos el contenido JSON
    }

    @Test
    void whenCreateUser_thenReturnMessageDto() throws Exception {
        // Arrange
        CreateAppUserDto createDto = new CreateAppUserDto("newuser", "pass123", "new@example.com", List.of("ROLE_USER"));
        MessageDto messageDto = new MessageDto("Usuario newuser guardado. Se ha enviado un correo de verificación.");

        when(appUserService.createUser(any(CreateAppUserDto.class))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(post("/auth/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated()) // Esperamos 201 Created
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenVerifyAccount_thenReturnMessageDto() throws Exception {
        // Arrange
        String token = "valid-token-123";
        MessageDto messageDto = new MessageDto("¡Tu cuenta ha sido verificada exitosamente!");

        when(appUserService.verifyAccount(eq(token))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(get("/auth/verify-account")
                        .param("token", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenGetUserByUsername_thenReturnUserDto() throws Exception {
        // Arrange
        String username = "testuser";
        UserDto userDto = UserDto.builder()
                .username(username)
                .email("test@example.com")
                .rut("11111111-1")
                .statusName("Activo")
                .build();

        when(appUserService.findUserByUsername(eq(username))).thenReturn(userDto);

        // Act & Assert
        mockMvc.perform(get("/auth/user/{username}", username)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
    }

    @Test
    void whenListUsersByStatus_thenReturnListOfUserDto() throws Exception {
        // Arrange
        Long statusId = 1L;
        UserDto userDto1 = UserDto.builder()
                .username("user1")
                .email("user1@example.com")
                .rut("11111111-1")
                .statusName("Activo")
                .build();
        List<UserDto> userDtoList = List.of(userDto1);

        when(appUserService.findUsersByStatus(eq(statusId))).thenReturn(userDtoList);

        // Act & Assert
        mockMvc.perform(get("/auth/users/by-status/{statusId}", statusId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDtoList)));
    }

    @Test
    void whenUpdatePassword_thenReturnMessageDto() throws Exception {
        // Arrange
        UpdatePasswordDto updateDto = new UpdatePasswordDto("test@example.com", "oldPass", "newPass");
        MessageDto messageDto = new MessageDto("Password updated successfully for user: test@example.com");

        when(appUserService.updatePassword(any(UpdatePasswordDto.class))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(post("/auth/update-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenResetPassword_thenReturnMessageDto() throws Exception {
        // Arrange
        ResetPasswordRequestDto resetDto = new ResetPasswordRequestDto("testuser", "12345678-9");
        MessageDto messageDto = new MessageDto("Se ha enviado una nueva contraseña al correo asociado a la cuenta.");

        when(appUserService.resetPassword(any(ResetPasswordRequestDto.class))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(post("/auth/reset-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(resetDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenAssignRoles_thenReturnMessageDto() throws Exception {
        // Arrange
        AssignRolesRequestDto assignDto = new AssignRolesRequestDto("testuser", List.of("ROLE_ADMIN"));
        MessageDto messageDto = new MessageDto("Roles actualizados para el usuario: testuser");

        when(appUserService.assignRolesToUser(any(AssignRolesRequestDto.class))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(post("/auth/assign-roles")
                        .with(user("admin").roles("ADMIN")) // Simula un usuario con rol ADMIN
                        .with(csrf()) // Añade el token CSRF
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assignDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }
}
