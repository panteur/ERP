package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateAppUserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sysconnect.dev.erp_proyect.authentication_service.utils.GeneradorCadenasAleatorias.generarCadenaAleatoria;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageDto createUser(CreateAppUserDto dto) {
        AppUser appUser = AppUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .email(dto.email())
                .build();

        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r -> {
            Role role = roleRepository.findByRole(RoleName.valueOf(r))
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role);
        });
        appUser.setRoles(roles);
        appUserRepository.save(appUser);
        return new MessageDto("user " + appUser.getUsername() + " saved");
    }

    @Override
    public AppUser findByRut(String rut) {return appUserRepository.findByRut(rut).orElse(null);}

    @Override
    public AppUser findByEmail(String email) {return appUserRepository.findByEmail(email).orElse(null);}

    @Override
    public AppUser findByUsername(String username) {return appUserRepository.findByUsername(username).orElse(null);}

    @Override
    public List<AppUser> findAll() {return appUserRepository.findAll();}



    @Override
    public AppUser delete(Long id) {
        AppUser appUserDB = appUserRepository.findById(id).orElse(null);
        if (appUserDB == null) return null;
        appUserRepository.delete(appUserDB);
        return appUserDB;

    }

    @Override
    public MessageDto disabledAccount(String rut) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        if(appUserDB.isDisabled()) return null;
        appUserDB.setDisabled(true);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta deshabilitada");
    }

    @Override
    public MessageDto lockedAccount(String rut) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        if( appUserDB.isLocked()) return null;
        appUserDB.setLocked(true);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta bloqueada");
    }

    @Override
    public MessageDto unLocketAccount(String rut) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        if( !appUserDB.isLocked()) return null;
        appUserDB.setLocked(false);
        return new MessageDto("user " + appUserDB.getUsername() + " Cuenta desbloqueada");
    }

    @Override
    public MessageDto enableAccount(String rut) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        if( !appUserDB.isDisabled()) return null;
        appUserDB.setDisabled(false);
       return new MessageDto("user " + appUserDB.getUsername() + " Cuenta habilitada");
    }

    @Override
    public MessageDto changePassword(String rut, String newPassword) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setPassword(passwordEncoder.encode(newPassword));
        appUserDB.setPasswordIsNew(false);
        return new MessageDto("user " + appUserDB.getUsername() + " Contraseña cambiada");
    }

    @Override
    public AppUser resetPassword(String rut) {
        String cadenaAleatoria = generarCadenaAleatoria(20);
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setPassword(passwordEncoder.encode((cadenaAleatoria)));
        appUserDB.setPasswordIsNew(true);
        // envio via email la nueva contraseña
        return appUserDB;
    }

    @Override
    public MessageDto setExpiredPasswordDate(String rut, Date date) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setPasswordExpDate(date);
        if (!appUserDB.getPasswordExpired()){
            appUserDB.setPasswordExpired(true);
        }
        return new MessageDto("user " + appUserDB.getUsername() + " Fecha de expiración de contraseña establecida");
    }

    @Override
    public MessageDto clearPasswordExpired(String rut) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setExpired(false);
        return new MessageDto("user " + appUserDB.getUsername() + " Contraseña actualizada");
    }

    @Override
    public MessageDto emailUpdate(String rut, String email) {
        AppUser appUserDB = appUserRepository.findByRut(rut).orElse(null);
        if (appUserDB == null) return null;
        appUserDB.setEmail(email);
        return new MessageDto("user " + appUserDB.getUsername() + " Email actualizado");
    }

}
