package com.sysconnect.dev.erp_proyect.authentication_service.controller;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.UserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserWithStatus(@PathVariable String username) {
        return ResponseEntity.ok(appUserService.findUserByUsername(username));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listAllUsers() {
        return ResponseEntity.ok(appUserService.findAllUsersWithStatus());
    }

    @GetMapping("/by-status/{statusId}")
    public ResponseEntity<List<UserDto>> listUsersByStatus(@PathVariable Long statusId) {
        return ResponseEntity.ok(appUserService.findUsersByStatus(statusId));
    }
}
