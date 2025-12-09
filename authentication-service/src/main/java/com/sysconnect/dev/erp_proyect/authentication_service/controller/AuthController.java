package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "Endpoints para registro, verificación y gestión de contraseñas")
public class AuthController {

    private final AppUserService appUserService;

    @Operation(summary = "Crear un nuevo usuario", description = "Registra un nuevo usuario en el sistema y envía un correo de verificación.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o el usuario ya existe")
    })
    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@Valid @RequestBody CreateAppUserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
    }

    @Operation(summary = "Verificar cuenta de usuario", description = "Activa la cuenta de un usuario utilizando el token de verificación enviado por correo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta verificada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Token de verificación inválido o expirado")
    })
    @GetMapping("/verify-account")
    public ResponseEntity<MessageDto> verifyAccount(@RequestParam String token) {
        return ResponseEntity.ok(appUserService.verifyAccount(token));
    }

    @Operation(summary = "Actualizar contraseña", description = "Permite a un usuario autenticado cambiar su propia contraseña.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contraseña actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o la contraseña actual no coincide"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/update-password")
    public ResponseEntity<MessageDto> updatePassword(@Valid @RequestBody UpdatePasswordDto dto) {
        return ResponseEntity.ok(appUserService.updatePassword(dto));
    }

    @Operation(summary = "Solicitar reseteo de contraseña (obsoleto)", description = "Este endpoint puede ser obsoleto, considere usar /forgot-password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud procesada"),
    })
    @PostMapping("/reset-password")
    public ResponseEntity<MessageDto> resetPassword(@Valid @RequestBody ResetPasswordRequestDto dto) {
        return ResponseEntity.ok(appUserService.resetPassword(dto));
    }

    @Operation(summary = "Solicitar olvido de contraseña", description = "Inicia el proceso para restablecer la contraseña de un usuario que la ha olvidado, enviando un correo con instrucciones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Si el usuario existe, se habrán enviado instrucciones por correo"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping("/forgot-password")
    public ResponseEntity<MessageDto> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDto dto) {
        return ResponseEntity.ok(appUserService.forgotPassword(dto));
    }

    @Operation(summary = "Confirmar reseteo de contraseña", description = "Establece una nueva contraseña utilizando el token enviado al correo del usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contraseña restablecida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Token de reseteo inválido o expirado")
    })
    @PostMapping("/reset-password-confirm")
    public ResponseEntity<MessageDto> resetPasswordConfirm(@Valid @RequestBody ResetPasswordConfirmDto dto) {
        return ResponseEntity.ok(appUserService.resetPasswordConfirm(dto));
    }
}
