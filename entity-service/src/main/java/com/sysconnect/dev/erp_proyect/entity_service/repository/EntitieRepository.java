package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EntitieRepository extends JpaRepository<Entitie, Long> {
    @Query("select e from Entitie e where e.rut = ?1")
    Optional<Entitie> findByRut(String rut);

    @Query("select e from Entitie e where e.entitieType = ?1")
    List<Entitie> findByEntitieType(String entitieType);

}