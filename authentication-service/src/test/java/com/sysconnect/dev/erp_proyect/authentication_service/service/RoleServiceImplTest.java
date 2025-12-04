package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateRoleDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
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

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    private Role adminRole;
    private Role userRole;

    @BeforeEach
    void setUp() {
        adminRole = Role.builder().id(1L).role("ROLE_ADMIN").description("Administrator role").build();
        userRole = Role.builder().id(2L).role("ROLE_USER").description("Standard user role").build();
    }

    @Test
    void whenCreateRole_withNewValidRoleName_thenCreateAndReturnSuccessMessage() {
        // Arrange
        CreateRoleDto dto = new CreateRoleDto("auditor", "Auditor role");
        String normalizedRoleName = "ROLE_AUDITOR";
        Role newRole = Role.builder().role(normalizedRoleName).description("Auditor role").build();

        when(roleRepository.findByRole(normalizedRoleName)).thenReturn(Optional.empty());
        when(roleRepository.save(any(Role.class))).thenReturn(newRole);

        // Act
        MessageDto result = roleService.createRole(dto);

        // Assert
        assertThat(result.message()).isEqualTo("Role " + normalizedRoleName + " created successfully.");
        verify(roleRepository, times(1)).findByRole(normalizedRoleName);
        verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void whenCreateRole_withExistingRoleName_thenThrowRuntimeException() {
        // Arrange
        CreateRoleDto dto = new CreateRoleDto("ROLE_ADMIN", "Admin role");
        String normalizedRoleName = "ROLE_ADMIN";

        when(roleRepository.findByRole(normalizedRoleName)).thenReturn(Optional.of(adminRole));

        // Act & Assert
        assertThatThrownBy(() -> roleService.createRole(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Role " + normalizedRoleName + " already exists.");

        verify(roleRepository, times(1)).findByRole(normalizedRoleName);
        verify(roleRepository, never()).save(any(Role.class));
    }

    @Test
    void whenFindByRoleName_withExistingRole_thenReturnOptionalOfRole() {
        // Arrange
        String roleName = "ROLE_ADMIN";
        when(roleRepository.findByRole(roleName)).thenReturn(Optional.of(adminRole));

        // Act
        Optional<Role> foundRole = roleService.findByRoleName(roleName);

        // Assert
        assertThat(foundRole).isPresent();
        assertThat(foundRole.get().getRole()).isEqualTo(roleName);
        verify(roleRepository, times(1)).findByRole(roleName);
    }

    @Test
    void whenFindByRoleName_withNonExistingRole_thenReturnEmptyOptional() {
        // Arrange
        String roleName = "ROLE_AUDITOR";
        when(roleRepository.findByRole(roleName)).thenReturn(Optional.empty());

        // Act
        Optional<Role> foundRole = roleService.findByRoleName(roleName);

        // Assert
        assertThat(foundRole).isNotPresent();
        verify(roleRepository, times(1)).findByRole(roleName);
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

    @Test
    void whenDeleteRole_andRoleIsNotInUse_thenDeleteRole() {
        // Arrange
        Long roleId = 1L;
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(adminRole));
        when(appUserRepository.countByRolesContains(adminRole)).thenReturn(0L);
        doNothing().when(roleRepository).delete(adminRole);

        // Act
        MessageDto result = roleService.deleteRole(roleId);

        // Assert
        assertThat(result.message()).isEqualTo("Role '" + adminRole.getRole() + "' deleted successfully.");
        verify(roleRepository, times(1)).findById(roleId);
        verify(appUserRepository, times(1)).countByRolesContains(adminRole);
        verify(roleRepository, times(1)).delete(adminRole);
    }

    @Test
    void whenDeleteRole_andRoleIsInUse_thenThrowRuntimeException() {
        // Arrange
        Long roleId = 1L;
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(adminRole));
        when(appUserRepository.countByRolesContains(adminRole)).thenReturn(5L); // 5 usuarios usan este rol

        // Act & Assert
        assertThatThrownBy(() -> roleService.deleteRole(roleId))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Cannot delete role '" + adminRole.getRole() + "' because it is currently assigned to 5 user(s).");

        verify(roleRepository, times(1)).findById(roleId);
        verify(appUserRepository, times(1)).countByRolesContains(adminRole);
        verify(roleRepository, never()).delete(any(Role.class));
    }

    @Test
    void whenDeleteRole_withNonExistentId_thenThrowRuntimeException() {
        // Arrange
        Long roleId = 99L;
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> roleService.deleteRole(roleId))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Role not found with id: " + roleId);

        verify(roleRepository, times(1)).findById(roleId);
        verifyNoInteractions(appUserRepository);
        verify(roleRepository, never()).delete(any(Role.class));
    }
}
