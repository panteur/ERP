package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Tag(name = "Gestión de Roles", description = "Endpoints para la creación, listado y eliminación de roles")
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "Crear un nuevo rol", description = "Crea un nuevo rol en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rol creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o el rol ya existe")
    })
    @PostMapping("/create")
    public ResponseEntity<MessageDto> createRole(@Valid @RequestBody CreateRoleDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(dto));
    }

    @Operation(summary = "Listar todos los roles", description = "Devuelve una lista de todos los roles disponibles en el sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente")
    @GetMapping("/list")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @Operation(summary = "Eliminar un rol", description = "Elimina un rol del sistema por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteRole(
            @Parameter(description = "ID del rol a eliminar", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(roleService.deleteRole(id));
    }
}
