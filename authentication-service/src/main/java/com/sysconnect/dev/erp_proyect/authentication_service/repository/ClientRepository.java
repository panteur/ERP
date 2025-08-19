package com.sysconnect.dev.erp_proyect.authentication_service.repository;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query("select c from Client c where c.clientId = ?1")
    Optional<Client> findByClientId(String clientId);
}