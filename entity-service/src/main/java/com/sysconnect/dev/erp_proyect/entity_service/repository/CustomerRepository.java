package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EmailStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.entitie.id = ?1")
    Optional<Customer> findByEntitie_Id(Long id);

    @Query("select c from Customer c where c.lastPurchase < ?1")
    List<Customer> findByLastPurchaseBefore(Date lastPurchase);

    @Query("select c from Customer c where c.statusId = ?1")
    List<Customer> findByStatusId(Long statusId);

    @Query("select c from Customer c where c.emailStatus = ?1")
    List<Customer> findByEmailStatus(EmailStatus emailStatus);

    @Query("select c from Customer c where c.email = ?1")
    Optional<Customer> findByEmail(String email);
}