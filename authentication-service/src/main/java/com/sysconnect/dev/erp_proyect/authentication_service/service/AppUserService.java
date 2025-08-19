package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.CreateAppUserDto;
import com.sysconnect.dev.erp_proyect.authentication_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;

import java.util.Date;
import java.util.List;

public interface AppUserService {

    public MessageDto createUser(CreateAppUserDto dto);

    public AppUser findByRut(String rut);

    public AppUser findByEmail(String email);

    public AppUser findByUsername(String username);

    public List<AppUser> findAll();

    public AppUser delete(Long id);

    public MessageDto disabledAccount(String rut);

    public MessageDto lockedAccount(String rut);

    public MessageDto unLocketAccount(String rut);

    public MessageDto enableAccount(String rut);

    public MessageDto changePassword(String rut, String newPassword);

    public AppUser resetPassword(String rut);

    public MessageDto setExpiredPasswordDate(String rut, Date date);

    public MessageDto clearPasswordExpired(String rut);

    public MessageDto emailUpdate(String rut, String email);
}
