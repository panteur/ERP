package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record AssignRolesRequestDto(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotEmpty(message = "Roles list cannot be empty")
        List<String> roleNames
) {
}
