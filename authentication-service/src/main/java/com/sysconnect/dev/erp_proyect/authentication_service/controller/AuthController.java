package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateAppUserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.UpdatePasswordDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    // Crear Usuario
    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
    }

    @GetMapping("/verify-account")
    public ResponseEntity<MessageDto> verifyAccount(@RequestParam String token) {
        return ResponseEntity.ok(appUserService.verifyAccount(token));
    }

    @PostMapping("/update-password")
    public ResponseEntity<MessageDto> updatePassword(@RequestBody UpdatePasswordDto dto) {
        return ResponseEntity.ok(appUserService.updatePassword(dto));
    }

}
