package com.sysconnect.dev.erp_proyect.authentication_service.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.sysconnect.dev.erp_proyect.authentication_service.model.Status;

import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "app_user")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    //EmailVerified
    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Column(name = "verification_token", nullable = true)
    private String verificationToken;

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_role",
            joinColumns = @JoinColumn(name = "appUser_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    //expired
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


    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "rut")
    private String rut;

    @Column(name = "password_is_new")
    private Boolean passwordIsNew = true;

    @Temporal(TemporalType.DATE)
    @Column(name = "password_exp_date")
    private Date passwordExpDate;

    @Column(name = "password_expired")
    private Boolean passwordExpired = false;

    // ROLES
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }
}
