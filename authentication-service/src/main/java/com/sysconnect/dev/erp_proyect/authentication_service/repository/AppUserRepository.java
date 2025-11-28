package com.sysconnect.dev.erp_proyect.authentication_service.repository;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Query("select a from AppUser a where a.username = ?1")
    Optional<AppUser> findByUsername(String username);

    @Query("select a from AppUser a where a.email = ?1")
    Optional<AppUser> findByEmail(String email);

    @Query("select a from AppUser a where a.verificationToken = ?1")
    Optional<AppUser> findByVerificationToken(String token);

    @Query("select a from AppUser a where a.emailVerified = ?1")
    List<AppUser> findByEmailVerified(boolean emailVerified);

    List<AppUser> findByDisabled(boolean disabled);

    List<AppUser> findByLocked(boolean locked);

    @Query("select a from AppUser a where a.rut = ?1")
    Optional<AppUser> findByRut(String rut);

    @Query("select a from AppUser a where a.passwordIsNew = ?1")
    List<AppUser> findByPasswordIsNew(Boolean passwordIsNew);

    @Query("select a from AppUser a where a.passwordExpDate = ?1")
    List<AppUser> findByPasswordExpDate(Date passwordExpDate);

    @Query("select a from AppUser a where a.passwordExpired = ?1")
    List<AppUser> findByPasswordExpired(Boolean passwordExpired);
}
