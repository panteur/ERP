package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Criticity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface CriticityRepository extends JpaRepository<Criticity, Long> {


    List<Criticity> findByNameContainsIgnoreCase(String name);

    Criticity findByCodint(String codint);

    List<Criticity> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<Criticity> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);

    @Query("select (count(c) > 0) from Criticity c where c.name = ?1")
    boolean existsByName(String name);
}