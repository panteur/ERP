package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import com.sysconnect.dev.erp_proyect.authentication_service.feignclients.StatusFeignClient;
import com.sysconnect.dev.erp_proyect.authentication_service.model.Status;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.utils.GeneradorCadenasAleatorias; // Importar la clase estática
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppUserServiceImplTest {

    // Mocks: Creamos "dobles de prueba" para todas las dependencias.
    // No se comportan como los reales, nosotros les diremos qué hacer.
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private EmailService emailService;
    @Mock
    private StatusFeignClient statusFeignClient;

    // InjectMocks: Crea una instancia real de AppUserServiceImpl e intenta
    // inyectar los mocks de arriba en ella.
    @InjectMocks
    private AppUserServiceImpl appUserService;

    private AppUser user;
    private Status status;
    private Role userRole;
    private Role adminRole;

    @BeforeEach
    void setUp() {
        user = AppUser.builder()
                .id(1L)
                .username("testuser")
                .password("encodedPassword")
                .email("test@example.com")
                .rut("12345678-9")
                .statusId(1L) // El ID del estado que usaremos para buscar
                .emailVerified(true)
                .passwordIsNew(false)
                .expired(false)
                .locked(false)
                .credentialsExpired(false)
                .disabled(false)
                .passwordExpired(false) // CORRECCIÓN: Inicializar passwordExpired
                .build();

        status = new Status();
        status.setName("Activo");
        status.setCodint("ACT");
        status.setDescription("Estado Activo");

        userRole = Role.builder().id(1L).role(RoleName.ROLE_USER).build();
        adminRole = Role.builder().id(2L).role(RoleName.ROLE_ADMIN).build();
    }

    @Test
    void whenFindUserByUsername_thenReturnUserDtoWithStatus() {
        String username = "testuser";
        when(appUserRepository.findByUsername(username)).thenReturn(Optional.of(user));
        when(statusFeignClient.getStatus(user.getStatusId())).thenReturn(status);

        UserDto resultDto = appUserService.findUserByUsername(username);

        assertThat(resultDto).isNotNull();
        assertThat(resultDto.getUsername()).isEqualTo("testuser");
        assertThat(resultDto.getRut()).isEqualTo("12345678-9");
        assertThat(resultDto.getStatusName()).isEqualTo("Activo");

        verify(appUserRepository, times(1)).findByUsername(username);
        verify(statusFeignClient, times(1)).getStatus(user.getStatusId());
    }

    @Test
    void whenFindUserByUsername_userNotFound_thenThrowRuntimeException() {
        String username = "nonexistent";
        when(appUserRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.findUserByUsername(username))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Usuario no encontrado");

        verify(appUserRepository, times(1)).findByUsername(username);
        verifyNoInteractions(statusFeignClient); // No debería llamar al feign client
    }

    @Test
    void whenCreateUser_thenSaveUserAndSendVerificationEmail() {
        CreateAppUserDto dto = new CreateAppUserDto(
                "newuser", "rawPassword", "newuser@example.com", List.of("ROLE_USER") // CORRECCIÓN: Usar List.of
        );
        when(passwordEncoder.encode(dto.password())).thenReturn("encodedNewPassword");
        when(roleRepository.findByRole(RoleName.ROLE_USER)).thenReturn(Optional.of(userRole));
        when(appUserRepository.save(any(AppUser.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Devuelve el mismo objeto guardado

        MessageDto result = appUserService.createUser(dto);

        assertThat(result.message()).contains("guardado. Se ha enviado un correo de verificación.");

        verify(passwordEncoder, times(1)).encode(dto.password());
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_USER);
        verify(appUserRepository, times(1)).save(any(AppUser.class));
        verify(emailService, times(1)).sendEmail(eq(dto.email()), eq("Verifica tu cuenta"), anyString());
    }

    @Test
    void whenCreateUser_roleNotFound_thenThrowRuntimeException() {
        CreateAppUserDto dto = new CreateAppUserDto(
                "newuser", "rawPassword", "newuser@example.com", List.of("ROLE_ADMIN") // CORRECCIÓN: Usar List.of
        );
        when(passwordEncoder.encode(dto.password())).thenReturn("encodedNewPassword"); // Mockear la llamada esperada
        when(roleRepository.findByRole(RoleName.ROLE_ADMIN)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.createUser(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Role not found");

        verify(passwordEncoder, times(1)).encode(dto.password()); // Verificar que sí se llamó
        verifyNoInteractions(appUserRepository, emailService); // Verificar que estos no se llamaron
    }

    @Test
    void whenVerifyAccount_thenSetEmailVerifiedAndClearToken() {
        String token = "validToken";
        user.setEmailVerified(false); // Asegurarse de que no esté verificado inicialmente
        user.setVerificationToken(token);
        when(appUserRepository.findByVerificationToken(token)).thenReturn(Optional.of(user));
        when(appUserRepository.save(any(AppUser.class))).thenAnswer(invocation -> invocation.getArgument(0));

        MessageDto result = appUserService.verifyAccount(token);

        assertThat(result.message()).isEqualTo("¡Tu cuenta ha sido verificada exitosamente!");
        assertThat(user.isEmailVerified()).isTrue();
        assertThat(user.getVerificationToken()).isNull();

        verify(appUserRepository, times(1)).findByVerificationToken(token);
        verify(appUserRepository, times(1)).save(user);
    }

    @Test
    void whenVerifyAccount_invalidToken_thenThrowRuntimeException() {
        String token = "invalidToken";
        when(appUserRepository.findByVerificationToken(token)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.verifyAccount(token))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Token de verificación inválido.");

        verify(appUserRepository, times(1)).findByVerificationToken(token);
        verifyNoMoreInteractions(appUserRepository);
    }

    @Test
    void whenFindAllUsersWithStatus_thenReturnListOfUserDto() {
        AppUser user2 = AppUser.builder().id(2L).username("user2").statusId(2L).build();
        List<AppUser> users = List.of(user, user2);
        Status status2 = new Status();
        status2.setName("Inactivo");

        when(appUserRepository.findAll()).thenReturn(users);
        when(statusFeignClient.getStatus(user.getStatusId())).thenReturn(status);
        when(statusFeignClient.getStatus(user2.getStatusId())).thenReturn(status2);

        List<UserDto> result = appUserService.findAllUsersWithStatus();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(0).getStatusName()).isEqualTo(status.getName());
        assertThat(result.get(1).getUsername()).isEqualTo(user2.getUsername());
        assertThat(result.get(1).getStatusName()).isEqualTo(status2.getName());

        verify(appUserRepository, times(1)).findAll();
        verify(statusFeignClient, times(1)).getStatus(user.getStatusId());
        verify(statusFeignClient, times(1)).getStatus(user2.getStatusId());
    }

    @Test
    void whenFindUsersByStatus_thenReturnListOfUserDto() {
        Long statusId = 1L;
        List<AppUser> usersWithStatus = List.of(user); // user tiene statusId 1L

        when(statusFeignClient.getStatus(statusId)).thenReturn(status);
        when(appUserRepository.findByStatusId(statusId)).thenReturn(usersWithStatus);

        List<UserDto> result = appUserService.findUsersByStatus(statusId);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(result.get(0).getStatusName()).isEqualTo(status.getName());

        verify(statusFeignClient, times(1)).getStatus(statusId);
        verify(appUserRepository, times(1)).findByStatusId(statusId);
    }

    @Test
    void whenUpdatePassword_thenChangePasswordAndSendEmail() {
        UpdatePasswordDto dto = new UpdatePasswordDto("test@example.com", "oldPassword", "newPassword");
        String originalPassword = user.getPassword(); // Capturar la contraseña original
        
        when(appUserRepository.findByEmail(dto.email())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(dto.currentPassword(), originalPassword)).thenReturn(true); // Usar la original aquí
        when(passwordEncoder.encode(dto.newPassword())).thenReturn("encodedNewPassword");
        when(appUserRepository.save(any(AppUser.class))).thenAnswer(invocation -> invocation.getArgument(0));

        MessageDto result = appUserService.updatePassword(dto);

        assertThat(result.message()).contains("Password updated successfully");
        assertThat(user.getPassword()).isEqualTo("encodedNewPassword");
        assertThat(user.getPasswordIsNew()).isFalse();
        assertThat(user.getPasswordExpDate()).isNotNull();
        assertThat(user.getPasswordExpired()).isFalse();

        verify(appUserRepository, times(1)).findByEmail(dto.email());
        verify(passwordEncoder, times(1)).matches(dto.currentPassword(), originalPassword); // Y aquí
        verify(passwordEncoder, times(1)).encode(dto.newPassword());
        verify(appUserRepository, times(1)).save(user);
        verify(emailService, times(1)).sendEmail(eq(dto.email()), anyString(), anyString());
    }

    @Test
    void whenUpdatePassword_userNotFound_thenThrowRuntimeException() {
        UpdatePasswordDto dto = new UpdatePasswordDto("nonexistent@example.com", "oldPassword", "newPassword");
        when(appUserRepository.findByEmail(dto.email())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.updatePassword(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User not found with email");

        verify(appUserRepository, times(1)).findByEmail(dto.email());
        verifyNoInteractions(passwordEncoder, emailService);
    }

    @Test
    void whenUpdatePassword_invalidCurrentPassword_thenThrowRuntimeException() {
        UpdatePasswordDto dto = new UpdatePasswordDto("test@example.com", "wrongOldPassword", "newPassword");
        String originalPassword = user.getPassword(); // Capturar la contraseña original
        
        when(appUserRepository.findByEmail(dto.email())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(dto.currentPassword(), originalPassword)).thenReturn(false); // Usar la original aquí

        assertThatThrownBy(() -> appUserService.updatePassword(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Invalid current password");

        verify(appUserRepository, times(1)).findByEmail(dto.email());
        verify(passwordEncoder, times(1)).matches(dto.currentPassword(), originalPassword); // Y aquí
        verifyNoMoreInteractions(passwordEncoder, appUserRepository, emailService);
    }

    @Test
    void whenResetPassword_thenGenerateNewPasswordAndSendEmail() {
        ResetPasswordRequestDto dto = new ResetPasswordRequestDto("testuser", "12345678-9");
        when(appUserRepository.findByUsernameAndRut(dto.username(), dto.rut())).thenReturn(Optional.of(user));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedRandomPassword");
        when(appUserRepository.save(any(AppUser.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Mockear el método estático GeneradorCadenasAleatorias.generarCadenaAleatoria
        try (MockedStatic<GeneradorCadenasAleatorias> mockedStatic = mockStatic(GeneradorCadenasAleatorias.class)) {
            mockedStatic.when(() -> GeneradorCadenasAleatorias.generarCadenaAleatoria(8)).thenReturn("randomPass");

            MessageDto result = appUserService.resetPassword(dto);

            assertThat(result.message()).contains("Se ha enviado una nueva contraseña");
            assertThat(user.getPassword()).isEqualTo("encodedRandomPassword");
            assertThat(user.getPasswordIsNew()).isTrue();
            assertThat(user.getPasswordExpDate()).isNull();
            assertThat(user.getPasswordExpired()).isTrue();

            verify(appUserRepository, times(1)).findByUsernameAndRut(dto.username(), dto.rut());
            verify(passwordEncoder, times(1)).encode("randomPass");
            verify(appUserRepository, times(1)).save(user);
            verify(emailService, times(1)).sendEmail(eq(user.getEmail()), anyString(), contains("randomPass"));
        }
    }

    @Test
    void whenResetPassword_userNotFound_thenThrowRuntimeException() {
        ResetPasswordRequestDto dto = new ResetPasswordRequestDto("nonexistent", "123");
        when(appUserRepository.findByUsernameAndRut(dto.username(), dto.rut())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.resetPassword(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Usuario no encontrado con el nombre de usuario y RUT proporcionados.");

        verify(appUserRepository, times(1)).findByUsernameAndRut(dto.username(), dto.rut());
        verifyNoInteractions(passwordEncoder, emailService);
    }

    @Test
    void whenLoadUserByUsername_userFound_thenReturnUserDetails() {
        String username = "testuser";
        when(appUserRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserDetails userDetails = appUserService.loadUserByUsername(username);

        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo(username);
        assertThat(userDetails.getPassword()).isEqualTo(user.getPassword());
        assertThat(userDetails.isEnabled()).isTrue(); // emailVerified es true en setUp
        assertThat(userDetails.isAccountNonExpired()).isTrue();
        assertThat(userDetails.isAccountNonLocked()).isTrue();
        assertThat(userDetails.isCredentialsNonExpired()).isTrue(); // passwordExpired es false en setUp

        verify(appUserRepository, times(1)).findByUsername(username);
    }

    @Test
    void whenLoadUserByUsername_userNotFound_thenThrowUsernameNotFoundException() {
        String username = "nonexistent";
        when(appUserRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> appUserService.loadUserByUsername(username))
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("Usuario no encontrado");

        verify(appUserRepository, times(1)).findByUsername(username);
    }

    @Test
    void whenLoadUserByUsername_passwordExpired_thenSetPasswordExpiredAndReturnUserDetails() {
        String username = "testuser";
        user.setPasswordExpDate(Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant())); // Expiró ayer
        user.setPasswordExpired(false); // Asegurarse de que no esté expirado inicialmente

        when(appUserRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserDetails userDetails = appUserService.loadUserByUsername(username);

        assertThat(userDetails).isNotNull();
        assertThat(userDetails.isCredentialsNonExpired()).isFalse(); // Ahora debería ser false
        assertThat(user.getPasswordExpired()).isTrue(); // El campo interno del usuario debería ser true

        verify(appUserRepository, times(1)).findByUsername(username);
    }

    @Test
    void whenAssignRolesToUser_thenUpdateUserRoles() {
        // Arrange
        AssignRolesRequestDto dto = new AssignRolesRequestDto("testuser", List.of("ROLE_ADMIN"));
        when(appUserRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(roleRepository.findByRole(RoleName.ROLE_ADMIN)).thenReturn(Optional.of(adminRole));

        // Act
        MessageDto result = appUserService.assignRolesToUser(dto);

        // Assert
        assertThat(result.message()).isEqualTo("Roles actualizados para el usuario: testuser");
        assertThat(user.getRoles()).hasSize(1);
        assertThat(user.getRoles()).contains(adminRole);

        verify(appUserRepository, times(1)).findByUsername("testuser");
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_ADMIN);
        verify(appUserRepository, times(1)).save(user);
    }

    @Test
    void whenAssignRolesToUser_withNonExistentRole_thenThrowRuntimeException() {
        // Arrange
        AssignRolesRequestDto dto = new AssignRolesRequestDto("testuser", List.of("ROLE_AUDITOR"));
        when(appUserRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(roleRepository.findByRole(RoleName.ROLE_AUDITOR)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> appUserService.assignRolesToUser(dto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Rol no encontrado: ROLE_AUDITOR");

        verify(appUserRepository, times(1)).findByUsername("testuser");
        verify(roleRepository, times(1)).findByRole(RoleName.ROLE_AUDITOR);
        verify(appUserRepository, never()).save(any(AppUser.class));
    }
}
