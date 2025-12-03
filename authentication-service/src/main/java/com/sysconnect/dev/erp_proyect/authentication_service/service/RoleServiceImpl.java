package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public MessageDto createRole(CreateRoleDto dto) {
        // 1. Normalizar el nombre del rol
        String normalizedRoleName = dto.roleName().trim().toUpperCase().replace(" ", "_");
        if (!normalizedRoleName.startsWith("ROLE_")) {
            normalizedRoleName = "ROLE_" + normalizedRoleName;
        }

        // 2. Validar que el roleName normalizado exista en el enum
        RoleName enumRoleName;
        try {
            enumRoleName = RoleName.valueOf(normalizedRoleName);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid RoleName: " + dto.roleName() + ". After normalization, '" + normalizedRoleName + "' is not a valid role. Must be one of " + Arrays.toString(RoleName.values()));
        }

        // 3. Verificar que el rol no exista ya en la base de datos
        if (roleRepository.findByRole(enumRoleName).isPresent()) {
            throw new RuntimeException("Role " + normalizedRoleName + " already exists.");
        }

        // 4. Crear y guardar el nuevo rol
        Role newRole = Role.builder()
                .role(enumRoleName)
                .description(dto.description())
                .build();
        roleRepository.save(newRole);

        return new MessageDto("Role " + newRole.getRole().name() + " created successfully.");
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        try {
            RoleName enumRoleName = RoleName.valueOf(roleName.toUpperCase());
            return roleRepository.findByRole(enumRoleName);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
