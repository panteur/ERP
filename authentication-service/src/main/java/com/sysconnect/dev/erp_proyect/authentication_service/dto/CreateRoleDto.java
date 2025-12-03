package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateRoleDto(
        @NotBlank(message = "Role name cannot be blank")
        String roleName,
        String description
) {
}
