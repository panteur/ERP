package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.feignclients.StatusFeignClient;
import com.sysconnect.dev.erp_proyect.authentication_service.model.Status;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.utils.GeneradorCadenasAleatorias;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static com.sysconnect.dev.erp_proyect.authentication_service.utils.GeneradorCadenasAleatorias.generarCadenaAleatoria;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final StatusFeignClient statusFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Comprobar si la contraseña ha expirado
        if (appUser.getPasswordExpDate() != null && new Date().after(appUser.getPasswordExpDate())) {
            appUser.setPasswordExpired(true);
            // Opcional: podrías guardar este cambio en la BD si quieres que persista
            // appUserRepository.save(appUser);
        }

        return appUser;
    }

    public MessageDto createUser(CreateAppUserDto dto) {
        String verificationToken = UUID.randomUUID().toString();
        AppUser appUser = AppUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .email(dto.email())
                .verificationToken(verificationToken)
                .emailVerified(false) // Por defecto, el email no está verificado
                .build();

        appUser.setStatusId(2L); // Asignar 2 por defecto

        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r -> {
            Role role = roleRepository.findByRole(r)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + r));
            roles.add(role);
        });
        appUser.setRoles(roles);
        appUserRepository.save(appUser);
        
        // Enviar correo de verificación
        String verificationLink = "http://localhost:9000/auth/verify-account?token=" + verificationToken;
        String subject = "Verifica tu cuenta";
        String body = "Hola " + appUser.getUsername() + ",\n\n"
                + "Gracias por registrarte. Por favor, haz clic en el siguiente enlace para verificar tu correo electrónico:\n"
                + verificationLink;
        emailService.sendEmail(appUser.getEmail(), subject, body);
        
        return new MessageDto("Usuario " + appUser.getUsername() + " guardado. Se ha enviado un correo de verificación.");
    }

    @Override
    public MessageDto verifyAccount(String token) {
        AppUser appUser = appUserRepository.findByVerificationToken(token)
                .orElseThrow(() -> new RuntimeException("Token de verificación inválido."));

        appUser.setEmailVerified(true);
        appUser.setVerificationToken(null); // Limpiar el token para que no se pueda usar de nuevo
        appUserRepository.save(appUser);

        return new MessageDto("¡Tu cuenta ha sido verificada exitosamente!");
    }

    @Override
    public UserDto findUserByUsername(String username) {
        AppUser appUser = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Status status = statusFeignClient.getStatus(appUser.getStatusId());

        return UserDto.builder()
                .username(appUser.getUsername())
                .email(appUser.getEmail())

                .emailVerified(appUser.isEmailVerified())
                .statusName(status.getName()) // Asumiendo que el objeto Status tiene un método getName()
                .expired(appUser.isExpired())
                .locked(appUser.isLocked())
                .credentialsExpired(appUser.isCredentialsExpired())
                .disabled(appUser.isDisabled())
                .build();
    }

    @Override
    public List<UserDto> findAllUsersWithStatus() {
        List<AppUser> users = appUserRepository.findAll();
        return users.stream()
                .map(appUser -> {
                    Status status = statusFeignClient.getStatus(appUser.getStatusId());
                    return UserDto.builder()
                            .username(appUser.getUsername())
                            .email(appUser.getEmail())

                            .emailVerified(appUser.isEmailVerified())
                            .statusName(status.getName())
                            .expired(appUser.isExpired())
                            .locked(appUser.isLocked())
                            .credentialsExpired(appUser.isCredentialsExpired())
                            .disabled(appUser.isDisabled())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersByStatus(Long statusId) {
        // 1. Llama al cliente Feign UNA SOLA VEZ para obtener el nombre del estado.
        Status status = statusFeignClient.getStatus(statusId);
        String statusName = (status != null) ? status.getName() : "Desconocido";

        // 2. Busca en la base de datos todos los usuarios con ese statusId.
        List<AppUser> users = appUserRepository.findByStatusId(statusId);

        // 3. Convierte la lista de AppUser a una lista de UserDto.
        return users.stream()
                .map(appUser -> UserDto.builder()
                        .username(appUser.getUsername())
                        .email(appUser.getEmail())

                        .emailVerified(appUser.isEmailVerified())
                        .statusName(statusName) // Asigna el nombre del estado (ya lo tenemos)
                        .expired(appUser.isExpired())
                        .locked(appUser.isLocked())
                        .credentialsExpired(appUser.isCredentialsExpired())
                        .disabled(appUser.isDisabled())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto assignRolesToUser(AssignRolesRequestDto dto) {
        AppUser appUser = appUserRepository.findByUsername(dto.username())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + dto.username()));

        Set<Role> roles = new HashSet<>();
        for (String roleName : dto.roleNames()) {
            Role role = roleRepository.findByRole(roleName)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + roleName));
            roles.add(role);
        }

        appUser.setRoles(roles);
        appUserRepository.save(appUser);

        return new MessageDto("Roles actualizados para el usuario: " + appUser.getUsername());
    }

    @Override
    public MessageDto forgotPassword(ForgotPasswordRequestDto dto) {
        AppUser appUser = appUserRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el email: " + dto.email()));

        String token = UUID.randomUUID().toString();
        appUser.setResetPasswordToken(token);
        // Expiración en 15 minutos
        appUser.setResetPasswordTokenExp(new Date(System.currentTimeMillis() + 900000)); 
        appUserRepository.save(appUser);

        String resetLink = "http://localhost:4200/reset-password?token=" + token; // URL del frontend
        String subject = "Solicitud de restablecimiento de contraseña";
        String body = "Hola " + appUser.getUsername() + ",\n\n"
                + "Has solicitado restablecer tu contraseña. Haz clic en el siguiente enlace para continuar:\n"
                + resetLink + "\n\n"
                + "Este enlace expirará en 15 minutos.";
        emailService.sendEmail(appUser.getEmail(), subject, body);

        return new MessageDto("Se ha enviado un enlace de restablecimiento de contraseña a tu correo electrónico.");
    }

    @Override
    public MessageDto resetPasswordConfirm(ResetPasswordConfirmDto dto) {
        AppUser appUser = appUserRepository.findByResetPasswordToken(dto.token())
                .orElseThrow(() -> new RuntimeException("Token de restablecimiento inválido."));

        if (appUser.getResetPasswordTokenExp().before(new Date())) {
            throw new RuntimeException("El token de restablecimiento ha expirado.");
        }

        appUser.setPassword(passwordEncoder.encode(dto.newPassword()));
        appUser.setPasswordIsNew(false);
        appUser.setResetPasswordToken(null);
        appUser.setResetPasswordTokenExp(null);
        appUserRepository.save(appUser);

        return new MessageDto("Contraseña actualizada exitosamente.");
    }


    @Override
    public AppUser findByEmail(String email) {return appUserRepository.findByEmail(email).orElse(null);}

    @Override
    public AppUser delete(Long id) {
        AppUser appUserDB = appUserRepository.findById(id).orElse(null);
        if (appUserDB == null) return null;
        appUserRepository.delete(appUserDB);
        return appUserDB;

    }

    @Override
    public MessageDto disabledAccount(String username) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        if(appUserDB.isDisabled()) return null;
        appUserDB.setDisabled(true);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta deshabilitada");
    }

    @Override
    public MessageDto lockedAccount(String username) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        if( appUserDB.isLocked()) return null;
        appUserDB.setLocked(true);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta bloqueada");
    }

    @Override
    public MessageDto unLocketAccount(String username) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        if( !appUserDB.isLocked()) return null;
        appUserDB.setLocked(false);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta desbloqueada");
    }

    @Override
    public MessageDto enableAccount(String username) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        if( !appUserDB.isDisabled()) return null;
        appUserDB.setDisabled(false);
       return new MessageDto("user " + appUserDB.getUsername() + " Cuenta habilitada");
    }

    @Override
    public MessageDto updatePassword(UpdatePasswordDto dto) {
        AppUser appUser = appUserRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + dto.email()));

        if (!passwordEncoder.matches(dto.currentPassword(), appUser.getPassword())) {
            throw new RuntimeException("Invalid current password");
        }

        appUser.setPassword(passwordEncoder.encode(dto.newPassword()));
        appUser.setPasswordIsNew(false); // La contraseña ya no es nueva

        // Establecer la nueva fecha de expiración (90 días desde hoy)
        LocalDate expirationDate = LocalDate.now().plusDays(90);
        appUser.setPasswordExpDate(Date.from(expirationDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        appUser.setPasswordExpired(false); // La contraseña ahora es válida

        appUserRepository.save(appUser);

        // Enviar correo de notificación
        String subject = "Actualización de contraseña";
        String body = "Hola " + appUser.getUsername() + ",\n\nTu contraseña ha sido actualizada exitosamente. Si no has sido tú, por favor, contacta con nosotros.";
        emailService.sendEmail(appUser.getEmail(), subject, body);

        return new MessageDto("Contraseña actualizada con éxito para el usuario: " + appUser.getUsername());
    }

    @Override
    public MessageDto resetPassword(ResetPasswordRequestDto dto) {
        AppUser appUser = appUserRepository.findByUsernameAndRut(dto.username(), dto.rut())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el nombre de usuario y RUT proporcionados."));

        String newPassword = generarCadenaAleatoria(8);
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser.setPasswordIsNew(true); // La contraseña es nueva y debe ser cambiada
        appUser.setPasswordExpDate(null); // La contraseña generada no tiene fecha de expiración
        appUser.setPasswordExpired(true); // Forzar al usuario a cambiarla
        appUserRepository.save(appUser);

        // Enviar la nueva contraseña por correo
        String subject = "Restablecimiento de contraseña";
        String body = "Hola " + appUser.getUsername() + ",\n\nTu nueva contraseña es: " + newPassword;
        emailService.sendEmail(appUser.getEmail(), subject, body);

        return new MessageDto("Se ha enviado una nueva contraseña al correo asociado a la cuenta.");
    }

    @Override
    public MessageDto setExpiredPasswordDate(String username, Date date) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setPasswordExpDate(date);
        if (!appUserDB.getPasswordExpired()){
            appUserDB.setPasswordExpired(true);
        }
        return new MessageDto("user " + appUserDB.getUsername() + " Fecha de expiración de contraseña establecida");
    }

    @Override
    public MessageDto clearPasswordExpired(String username) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setExpired(false);
        return new MessageDto("user " + appUserDB.getUsername() + " Contraseña actualizada");
    }

    @Override
    public MessageDto emailUpdate(String username, String email) {
        AppUser appUserDB = appUserRepository.findByUsername(username).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setEmail(email);
        return new MessageDto("user " + appUserDB.getUsername() + " Email actualizado");
    }

}
