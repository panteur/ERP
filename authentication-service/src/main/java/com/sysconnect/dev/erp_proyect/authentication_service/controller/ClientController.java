package com.sysconnect.dev.erp_proyect.authentication_service.controller;


import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateClientDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Gestión de Clientes OAuth2", description = "Endpoints para la creación de clientes OAuth2")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Crear un nuevo cliente OAuth2", description = "Registra una nueva aplicación cliente que podrá interactuar con el servidor de autorización.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o el cliente ya existe")
    })
    @PostMapping("/create")
    public ResponseEntity<MessageDto> create(@RequestBody CreateClientDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(dto));
    }
}
