package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysconnect.dev.erp_proyect.authentication_service.config.AuthorizationSecurityConfig;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.AssignRolesRequestDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AdminController.class, properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Import(AuthorizationSecurityConfig.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private ClientService clientService;

    @Test
    void whenAssignRoles_thenReturnMessageDto() throws Exception {
        AssignRolesRequestDto assignDto = new AssignRolesRequestDto("testuser", List.of("ROLE_ADMIN"));
        MessageDto messageDto = new MessageDto("Roles actualizados para el usuario: testuser");

        when(appUserService.assignRolesToUser(any(AssignRolesRequestDto.class))).thenReturn(messageDto);

        mockMvc.perform(post("/admin/users/assign-roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assignDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }
}
