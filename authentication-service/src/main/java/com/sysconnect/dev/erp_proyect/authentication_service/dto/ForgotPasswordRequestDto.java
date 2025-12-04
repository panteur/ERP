package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ForgotPasswordRequestDto(
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        String email
) {
}
