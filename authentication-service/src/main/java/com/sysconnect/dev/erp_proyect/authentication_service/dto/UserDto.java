package com.sysconnect.dev.erp_proyect.authentication_service.dto;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private String username;

    private String email;

    private boolean emailVerified = false;

    @Column(name = "expired", nullable = false)
    private boolean expired = false;

    //locked
    @Column(name = "locked", nullable = false)
    private boolean locked = false;

    //credentialsExpired
    @Column(name = "credentials_expired", nullable = false)
    private boolean credentialsExpired = false;

    //disabled
    @Column(name = "disabled", nullable = false)
    private boolean disabled = false;

}
