package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    private Role adminRole;
    private Role userRole;

    @BeforeEach
    void setUp() {
        adminRole = Role.builder().id(1L).role(RoleName.ROLE_ADMIN).description("Administrator role").build();
        userRole = Role.builder().id(2L).role(RoleName.ROLE_USER).description("Standard user role").build();
    }

    @Test
    void whenCreateRole_withNewValidRoleName_thenCreateAndReturnSuccessMessage() {
        // Arrange
        CreateRoleDto dto = new CreateRoleDto("ROLE_AUDITOR", "Auditor role");
        Role newRole = Role.builder().role(RoleName.ROLE_AUDITOR).description("Auditor role").build();

        when(roleRepository.findByRole(RoleName.ROLE_AUDITOR)).thenReturn(Optional.empty());
        when(roleRepository.save(any(Role.class))).thenReturn(newRole);

        // Act
        MessageDto result = roleService.createRole(dto);

        // Assert
        assertThat(result.message()).isEqualTo("Role ROLE_AUDITOR created successfully.");
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_AUDITOR);
        verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void whenCreateRole_withInvalidRoleName_thenThrowRuntimeException() {
        // Arrange
        CreateRoleDto dto = new CreateRoleDto("INVALID_ROLE", "Invalid role description");

        // Act & Assert
        assertThatThrownBy(() -> roleService.createRole(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid RoleName: INVALID_ROLE");

        verify(roleRepository, never()).save(any(Role.class));
    }

    @Test
    void whenCreateRole_withExistingRoleName_thenThrowRuntimeException() {
        // Arrange
        CreateRoleDto dto = new CreateRoleDto("ROLE_ADMIN", "Admin role");

        when(roleRepository.findByRole(RoleName.ROLE_ADMIN)).thenReturn(Optional.of(adminRole));

        // Act & Assert
        assertThatThrownBy(() -> roleService.createRole(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Role ROLE_ADMIN already exists.");

        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_ADMIN);
        verify(roleRepository, never()).save(any(Role.class));
    }

    @Test
    void whenFindByRoleName_withExistingRole_thenReturnOptionalOfRole() {
        // Arrange
        when(roleRepository.findByRole(RoleName.ROLE_ADMIN)).thenReturn(Optional.of(adminRole));

        // Act
        Optional<Role> foundRole = roleService.findByRoleName("ROLE_ADMIN");

        // Assert
        assertThat(foundRole).isPresent();
        assertThat(foundRole.get().getRole()).isEqualTo(RoleName.ROLE_ADMIN);
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_ADMIN);
    }

    @Test
    void whenFindByRoleName_withNonExistingRole_thenReturnEmptyOptional() {
        // Arrange
        when(roleRepository.findByRole(RoleName.ROLE_AUDITOR)).thenReturn(Optional.empty());

        // Act
        Optional<Role> foundRole = roleService.findByRoleName("ROLE_AUDITOR");

        // Assert
        assertThat(foundRole).isNotPresent();
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_AUDITOR);
    }

    @Test
    void whenFindByRoleName_withInvalidRoleName_thenReturnEmptyOptional() {
        // Act
        Optional<Role> foundRole = roleService.findByRoleName("NON_EXISTENT_ENUM_ROLE");

        // Assert
        assertThat(foundRole).isNotPresent();
        verify(roleRepository, never()).findByRole(any(RoleName.class)); // No debería llamar al repositorio
    }

    @Test
    void whenFindAll_thenReturnListOfAllRoles() {
        // Arrange
        List<Role> allRoles = List.of(adminRole, userRole);
        when(roleRepository.findAll()).thenReturn(allRoles);

        // Act
        List<Role> result = roleService.findAll();

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(adminRole, userRole);
        verify(roleRepository, times(1)).findAll();
    }
}
