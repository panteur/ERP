package com.sysconnect.dev.erp_proyect.authentication_service.repository;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.role = ?1")
    Optional<Role> findByRole(RoleName role);
}