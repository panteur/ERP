package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    MessageDto createRole(CreateRoleDto dto);
    Optional<Role> findByRoleName(String roleName);
    List<Role> findAll();
    MessageDto deleteRole(Long id);
}
