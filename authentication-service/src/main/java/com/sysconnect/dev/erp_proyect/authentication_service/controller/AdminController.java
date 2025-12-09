package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.AssignRolesRequestDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Administración", description = "Endpoints para tareas administrativas de usuarios")
public class AdminController {

    private final AppUserService appUserService;

    @Operation(summary = "Asignar roles a un usuario", description = "Asigna una lista de roles a un usuario específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roles asignados correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Usuario o roles no encontrados")
    })
    @PostMapping("/users/assign-roles")
    public ResponseEntity<MessageDto> assignRoles(@Valid @RequestBody AssignRolesRequestDto dto) {
        return ResponseEntity.ok(appUserService.assignRolesToUser(dto));
    }

    @Operation(summary = "Deshabilitar cuenta de usuario", description = "Marca la cuenta de un usuario como deshabilitada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta deshabilitada correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/users/{rut}/disable")
    public ResponseEntity<MessageDto> disableAccount(
            @Parameter(description = "RUT del usuario a deshabilitar", required = true)
            @PathVariable String rut) {
        return ResponseEntity.ok(appUserService.disabledAccount(rut));
    }

    @Operation(summary = "Habilitar cuenta de usuario", description = "Marca la cuenta de un usuario como habilitada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta habilitada correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/users/{rut}/enable")
    public ResponseEntity<MessageDto> enableAccount(
            @Parameter(description = "RUT del usuario a habilitar", required = true)
            @PathVariable String rut) {
        return ResponseEntity.ok(appUserService.enableAccount(rut));
    }

    @Operation(summary = "Bloquear cuenta de usuario", description = "Marca la cuenta de un usuario como bloqueada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta bloqueada correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/users/{rut}/lock")
    public ResponseEntity<MessageDto> lockAccount(
            @Parameter(description = "RUT del usuario a bloquear", required = true)
            @PathVariable String rut) {
        return ResponseEntity.ok(appUserService.lockedAccount(rut));
    }

    @Operation(summary = "Desbloquear cuenta de usuario", description = "Marca la cuenta de un usuario como desbloqueada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta desbloqueada correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PostMapping("/users/{rut}/unlock")
    public ResponseEntity<MessageDto> unlockAccount(
            @Parameter(description = "RUT del usuario a desbloquear", required = true)
            @PathVariable String rut) {
        return ResponseEntity.ok(appUserService.unLocketAccount(rut));
    }
}
