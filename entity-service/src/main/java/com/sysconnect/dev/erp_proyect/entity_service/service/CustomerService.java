package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerCreateDto;
import com.sysconnect.dev.erp_proyect.entity_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerService {


    public Customer findByEntitie_Id(Long id);
    List<Customer> findByNamesOrLastNamesContaining(String searchText);
    List<Customer> findByStatusId(Long statusId);
    List<Customer> findByBirthDate(Date birthDate);
    List<Customer> findBySex(Sex sex);
    List<Customer> findByFirstPurchaseBetween(Date firstPurchaseStart, Date firstPurchaseEnd);
    List<Customer> findByLastPurchaseBetween(Date lastPurchaseStart, Date lastPurchaseEnd);
    List<Customer> findAll();

    public MessageDto save(CustomerCreateDto dto);
    public Customer update(Customer customer);
    public MessageDto delete(Long id);
}
