package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.AssignRolesRequestDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AppUserService appUserService;

    @PostMapping("/users/assign-roles")
    public ResponseEntity<MessageDto> assignRoles(@Valid @RequestBody AssignRolesRequestDto dto) {
        return ResponseEntity.ok(appUserService.assignRolesToUser(dto));
    }

    @PostMapping("/users/{rut}/disable")
    public ResponseEntity<MessageDto> disableAccount(@PathVariable String rut) {
        return ResponseEntity.ok(appUserService.disabledAccount(rut));
    }

    @PostMapping("/users/{rut}/enable")
    public ResponseEntity<MessageDto> enableAccount(@PathVariable String rut) {
        return ResponseEntity.ok(appUserService.enableAccount(rut));
    }

    @PostMapping("/users/{rut}/lock")
    public ResponseEntity<MessageDto> lockAccount(@PathVariable String rut) {
        return ResponseEntity.ok(appUserService.lockedAccount(rut));
    }

    @PostMapping("/users/{rut}/unlock")
    public ResponseEntity<MessageDto> unlockAccount(@PathVariable String rut) {
        return ResponseEntity.ok(appUserService.unLocketAccount(rut));
    }
}
