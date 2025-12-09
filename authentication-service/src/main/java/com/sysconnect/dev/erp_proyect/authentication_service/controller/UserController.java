package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.UserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Gestión de Usuarios", description = "Endpoints para obtener información de usuarios")
public class UserController {

    private final AppUserService appUserService;

    @Operation(summary = "Obtener usuario por nombre de usuario", description = "Devuelve un único DTO de usuario por su nombre de usuario único.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUserName(
            @Parameter(description = "Nombre de usuario del usuario a obtener", required = true, example = "johndoe")
            @PathVariable String username) {
        return ResponseEntity.ok(appUserService.findUserByUsername(username));
    }

    @Operation(summary = "Listar todos los usuarios", description = "Devuelve una lista de todos los usuarios con su estado.")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<UserDto>> listAllUsers() {
        return ResponseEntity.ok(appUserService.findAllUsersWithStatus());
    }

    @Operation(summary = "Listar usuarios por estado", description = "Devuelve una lista de usuarios filtrados por el ID de su estado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "ID de estado no encontrado")
    })
    @GetMapping("/by-status/{statusId}")
    public ResponseEntity<List<UserDto>> listUsersByStatus(
            @Parameter(description = "ID del estado por el cual filtrar los usuarios", required = true, example = "1")
            @PathVariable Long statusId) {
        return ResponseEntity.ok(appUserService.findUsersByStatus(statusId));
    }
}
