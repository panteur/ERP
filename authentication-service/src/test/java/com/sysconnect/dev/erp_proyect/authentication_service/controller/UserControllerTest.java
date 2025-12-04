package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysconnect.dev.erp_proyect.authentication_service.config.AuthorizationSecurityConfig;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.UserDto;
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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class, properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.bootstrap.enabled=false"
})
@Import(AuthorizationSecurityConfig.class)
public class UserControllerTest {

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
    void whenGetUserByUsername_thenReturnUserDto() throws Exception {
        String username = "testuser";
        UserDto userDto = UserDto.builder().username(username).build();

        when(appUserService.findUserByUsername(eq(username))).thenReturn(userDto);

        mockMvc.perform(get("/users/{username}", username)
                        .with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
    }

    @Test
    void whenListAllUsers_thenReturnListOfUserDto() throws Exception {
        UserDto userDto1 = UserDto.builder().username("user1").build();
        UserDto userDto2 = UserDto.builder().username("user2").build();
        List<UserDto> userDtoList = List.of(userDto1, userDto2);

        when(appUserService.findAllUsersWithStatus()).thenReturn(userDtoList);

        mockMvc.perform(get("/users")
                        .with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDtoList)));
    }

    @Test
    void whenListUsersByStatus_thenReturnListOfUserDto() throws Exception {
        Long statusId = 1L;
        UserDto userDto1 = UserDto.builder().username("user1").build();
        List<UserDto> userDtoList = List.of(userDto1);

        when(appUserService.findUsersByStatus(eq(statusId))).thenReturn(userDtoList);

        mockMvc.perform(get("/users/by-status/{statusId}", statusId)
                        .with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDtoList)));
    }
}
