package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import lombok.Builder;

@Builder
public record ResetPasswordRequestDto(
        String username,
        String email
) {
}
