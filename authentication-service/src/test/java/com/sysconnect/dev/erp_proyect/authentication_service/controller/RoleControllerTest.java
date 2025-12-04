package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysconnect.dev.erp_proyect.authentication_service.config.AuthorizationSecurityConfig;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.service.ClientService;
import com.sysconnect.dev.erp_proyect.authentication_service.service.RoleService;
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
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf; // Importar csrf()
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user; // Importar user()
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = RoleController.class, properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Import(AuthorizationSecurityConfig.class) // Importa tu configuración de seguridad
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

    // Mocks necesarios para AuthorizationSecurityConfig
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private ClientService clientService;

    @Test
    void whenCreateRole_withValidDataAndAdminUser_thenReturnCreated() throws Exception {
        // Arrange
        CreateRoleDto createDto = new CreateRoleDto("ROLE_TEST", "Test Role Description");
        MessageDto messageDto = new MessageDto("Role ROLE_TEST created successfully.");

        when(roleService.createRole(any(CreateRoleDto.class))).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(post("/roles")
                        .with(user("admin").roles("ADMIN")) // Simula un usuario con rol ADMIN
                        .with(csrf()) // Añade el token CSRF
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenCreateRole_withInvalidRoleName_thenReturnBadRequest() throws Exception {
        // Arrange
        CreateRoleDto createDto = new CreateRoleDto("", "Description"); // Nombre de rol vacío
        // No mockeamos el servicio porque la validación @NotBlank debería fallar antes

        // Act & Assert
        mockMvc.perform(post("/roles")
                        .with(user("admin").roles("ADMIN")) // También necesita un usuario autenticado para pasar el filtro de seguridad
                        .with(csrf()) // Añade el token CSRF
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isBadRequest()); // Esperamos 400 Bad Request
    }

    @Test
    void whenGetAllRoles_thenReturnListOfRoles() throws Exception {
        // Arrange
        Role role1 = Role.builder().id(1L).role("ROLE_ADMIN").description("Admin").build();
        Role role2 = Role.builder().id(2L).role("ROLE_USER").description("User").build();
        List<Role> roles = List.of(role1, role2);

        when(roleService.findAll()).thenReturn(roles);

        // Act & Assert
        mockMvc.perform(get("/roles")
                        .with(user("admin").roles("ADMIN")) // También necesita un usuario autenticado
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(roles)));
    }

    @Test
    void whenDeleteRole_withAdminUser_thenReturnOk() throws Exception {
        // Arrange
        Long roleId = 1L;
        MessageDto messageDto = new MessageDto("Role 'ROLE_ADMIN' deleted successfully.");

        when(roleService.deleteRole(roleId)).thenReturn(messageDto);

        // Act & Assert
        mockMvc.perform(delete("/roles/{id}", roleId)
                        .with(user("admin").roles("ADMIN")) // Simula un usuario con rol ADMIN
                        .with(csrf())) // Añade el token CSRF
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }
}
