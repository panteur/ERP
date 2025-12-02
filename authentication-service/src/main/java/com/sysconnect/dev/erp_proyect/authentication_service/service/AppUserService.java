package com.sysconnect.dev.erp_proyect.authentication_service.service;

import com.sysconnect.dev.erp_proyect.authentication_service.dto.*;
import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;

import java.util.Date;
import java.util.List;

public interface AppUserService {

    public MessageDto createUser(CreateAppUserDto dto);

    public MessageDto verifyAccount(String token);

    public UserDto findUserByUsername(String username);

    public List<UserDto> findAllUsersWithStatus();

    public List<UserDto> findUsersByStatus(Long statusId);

    public AppUser findByRut(String rut);

    public AppUser findByEmail(String email);



    public AppUser delete(Long id);

    public MessageDto disabledAccount(String rut);



    public MessageDto lockedAccount(String rut);

    public MessageDto unLocketAccount(String rut);



    public MessageDto enableAccount(String rut);



    public MessageDto updatePassword(UpdatePasswordDto dto);

    public MessageDto resetPassword(ResetPasswordRequestDto dto);

    public MessageDto setExpiredPasswordDate(String rut, Date date);

    public MessageDto clearPasswordExpired(String rut);

    public MessageDto emailUpdate(String rut, String email);
}
