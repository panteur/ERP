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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = AuthController.class, properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Import(AuthorizationSecurityConfig.class)
public class AuthControllerTest {

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
    void whenCreateUser_thenReturnMessageDto() throws Exception {
        CreateAppUserDto createDto = new CreateAppUserDto("newuser", "pass123", "new@example.com", List.of("ROLE_USER"));
        MessageDto messageDto = new MessageDto("Usuario newuser guardado. Se ha enviado un correo de verificación.");

        when(appUserService.createUser(any(CreateAppUserDto.class))).thenReturn(messageDto);

        mockMvc.perform(post("/auth/create")
                        .with(csrf()) // CSRF es necesario para POST
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenVerifyAccount_thenReturnMessageDto() throws Exception {
        String token = "valid-token-123";
        MessageDto messageDto = new MessageDto("¡Tu cuenta ha sido verificada exitosamente!");

        when(appUserService.verifyAccount(eq(token))).thenReturn(messageDto);

        mockMvc.perform(get("/auth/verify-account")
                        .param("token", token))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenUpdatePassword_thenReturnMessageDto() throws Exception {
        UpdatePasswordDto updateDto = new UpdatePasswordDto("test@example.com", "oldPass", "newPass");
        MessageDto messageDto = new MessageDto("Password updated successfully for user: test@example.com");

        when(appUserService.updatePassword(any(UpdatePasswordDto.class))).thenReturn(messageDto);

        mockMvc.perform(post("/auth/update-password")
                        .with(csrf()) // CSRF es necesario para POST
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }

    @Test
    void whenResetPassword_thenReturnMessageDto() throws Exception {
        ResetPasswordRequestDto resetDto = new ResetPasswordRequestDto("testuser", "12345678-9");
        MessageDto messageDto = new MessageDto("Se ha enviado una nueva contraseña al correo asociado a la cuenta.");

        when(appUserService.resetPassword(any(ResetPasswordRequestDto.class))).thenReturn(messageDto);

        mockMvc.perform(post("/auth/reset-password")
                        .with(csrf()) // CSRF es necesario para POST
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(resetDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(messageDto)));
    }
}
