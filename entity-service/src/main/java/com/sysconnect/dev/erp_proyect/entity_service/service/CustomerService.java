package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EmailStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Customer findById(Long id);
    public Customer findByEntitie_Id(Long id);
    public List<Customer> findAll();
    public List<Customer> findByLastPurchaseBefore(Date lastPurchase);
    public List<Customer> findByStatusId(Long statusId);
    public List<Customer> findByEmailStatus(EmailStatus emailStatus);
    public Optional<Customer> findByEmail(String email);

    public Customer updateLastPurchase(Long id, Date lastPurchase);
    public Customer updateStatus(Long id, Long statusId);

    public Customer save(Customer customer);
    public Customer update(Customer customer);
    public Customer delete(Long id);
}
