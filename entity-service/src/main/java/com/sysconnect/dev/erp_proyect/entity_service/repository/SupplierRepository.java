package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("select s from Supplier s where s.entitie.id = ?1")
    Optional<Supplier> findByEntitie_Id(Long id);

    @Query("select s from Supplier s where s.statusId = ?1")
    List<Supplier> findByStatusId(Long statusId);

    @Query("select s from Supplier s where s.payDay = ?1")
    List<Supplier> findByPayDay(int payDay);
}