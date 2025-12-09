package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public MessageDto createRole(CreateRoleDto dto) {
        // 1. Normalizar el nombre del rol
        String normalizedRoleName = dto.roleName().trim().toUpperCase().replace(" ", "_");
        if (!normalizedRoleName.startsWith("ROLE_")) {
            normalizedRoleName = "ROLE_" + normalizedRoleName;
        }

        // 2. Verificar que el rol no exista ya en la base de datos
        if (roleRepository.findByRole(normalizedRoleName).isPresent()) {
            throw new RuntimeException("El rol " + normalizedRoleName + " ya existe.");
        }

        // 3. Crear y guardar el nuevo rol
        Role newRole = Role.builder()
                .role(normalizedRoleName)
                .description(dto.description())
                .build();
        roleRepository.save(newRole);

        return new MessageDto("Rol " + newRole.getRole() + " creado exitosamente.");
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return roleRepository.findByRole(roleName);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public MessageDto deleteRole(Long id) {
        // 1. Buscar el rol
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));

        // 2. Verificar si el rol está en uso
        long userCount = appUserRepository.countByRolesContains(role);
        if (userCount > 0) {
            throw new RuntimeException("No se puede eliminar el rol '" + role.getRole() + "' porque está asignado a " + userCount + " usuario(s).");
        }

        // 3. Eliminar el rol
        roleRepository.delete(role);

        return new MessageDto("Rol '" + role.getRole() + "' eliminado exitosamente.");
    }
}
