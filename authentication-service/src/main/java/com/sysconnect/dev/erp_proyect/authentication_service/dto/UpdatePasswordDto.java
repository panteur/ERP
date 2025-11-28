package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import lombok.Builder;

@Builder
public record UpdatePasswordDto(
        String email,
        String currentPassword,
        String newPassword
) {
}
