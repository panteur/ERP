package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import java.util.List;


public record CreateAppUserDto (
    String username,
    String password,
    String email,
    List<String> roles)
{}
