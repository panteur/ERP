package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {


    List<Status> findByStatusType_Id(Long id);

    List<Status> findByNameContainsIgnoreCase(String name);

    Status findByCodint(String codint);

    List<Status> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<Status> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);

    @Query("select s from Status s where s.statusType.name = ?1")
    Optional<Status> findByStatusType_Name(String name);

    @Query("select (count(s) > 0) from Status s where s.statusType.id = ?1 and s.codint = ?2")
    boolean existsByStatusType_IdAndCodint(Long id, String codint);

}
