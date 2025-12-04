package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@Valid @RequestBody CreateAppUserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
    }

    @GetMapping("/verify-account")
    public ResponseEntity<MessageDto> verifyAccount(@RequestParam String token) {
        return ResponseEntity.ok(appUserService.verifyAccount(token));
    }

    @PostMapping("/update-password")
    public ResponseEntity<MessageDto> updatePassword(@Valid @RequestBody UpdatePasswordDto dto) {
        return ResponseEntity.ok(appUserService.updatePassword(dto));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<MessageDto> resetPassword(@Valid @RequestBody ResetPasswordRequestDto dto) {
        return ResponseEntity.ok(appUserService.resetPassword(dto));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<MessageDto> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDto dto) {
        return ResponseEntity.ok(appUserService.forgotPassword(dto));
    }

    @PostMapping("/reset-password-confirm")
    public ResponseEntity<MessageDto> resetPasswordConfirm(@Valid @RequestBody ResetPasswordConfirmDto dto) {
        return ResponseEntity.ok(appUserService.resetPasswordConfirm(dto));
    }
}
