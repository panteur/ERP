package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface StatusTypeRepository extends JpaRepository<StatusType, Long> {


    List<StatusType> findByNameContainsIgnoreCase(String name);


    List<StatusType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<StatusType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);

    @Query("select (count(s) > 0) from StatusType s where s.name = ?1")
    boolean existsByName(String name);
}