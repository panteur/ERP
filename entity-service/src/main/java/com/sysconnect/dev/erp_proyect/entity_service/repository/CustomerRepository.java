package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.entitie.id = ?1")
    Optional<Customer> findByEntitie_Id(Long id);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.names) LIKE LOWER(CONCAT('%', :searchText, '%')) OR LOWER(c.lastNames) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Customer> findByNamesOrLastNamesContaining(@Param("searchText") String searchText);

    @Query("select c from Customer c where c.statusId = ?1")
    List<Customer> findByStatusId(Long statusId);

    @Query("select c from Customer c where c.birthDate = ?1")
    List<Customer> findByBirthDate(Date birthDate);

    @Query("select c from Customer c where c.sex = ?1")
    List<Customer> findBySex(Sex sex);

    @Query("select c from Customer c where c.firstPurchase between ?1 and ?2")
    List<Customer> findByFirstPurchaseBetween(Date firstPurchaseStart, Date firstPurchaseEnd);

    @Query("select c from Customer c where c.lastPurchase between ?1 and ?2")
    List<Customer> findByLastPurchaseBetween(Date lastPurchaseStart, Date lastPurchaseEnd);

}
