package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("select s from Supplier s where s.entitie.id = ?1")
    Optional<Supplier> findByEntitie_Id(Long id);

    @Query("select s from Supplier s where s.statusId = ?1")
    List<Supplier> findByStatusId(Long statusId);

    @Query("SELECT s FROM Supplier s WHERE LOWER(s.names) LIKE LOWER(CONCAT('%', :searchText, '%')) OR LOWER(s.lastNames) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Supplier> findByNamesOrLastNamesContaining(@Param("searchText") String searchText);

    @Query("select s from Supplier s where s.firstPurchase between ?1 and ?2")
    List<Supplier> findByFirstPurchaseBetween(Date firstPurchaseStart, Date firstPurchaseEnd);

    @Query("select s from Supplier s where s.lastPurchase between ?1 and ?2")
    List<Supplier> findByLastPurchaseBetween(Date lastPurchaseStart, Date lastPurchaseEnd);

}