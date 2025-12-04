package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ResetPasswordConfirmDto(
        @NotBlank(message = "Token cannot be blank")
        String token,

        @NotBlank(message = "New password cannot be blank")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String newPassword
) {
}
