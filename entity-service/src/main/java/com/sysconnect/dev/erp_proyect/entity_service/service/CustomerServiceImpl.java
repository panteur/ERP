package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EmailStatus;
import com.sysconnect.dev.erp_proyect.entity_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {return customerRepository.findById(id).orElse(null);}

    @Override
    public Customer findByEntitie_Id(Long id) {return customerRepository.findByEntitie_Id(id).orElse(null); }

    @Override
    public List<Customer> findAll() {return customerRepository.findAll();}

    @Override
    public List<Customer> findByLastPurchaseBefore(Date lastPurchase) {return customerRepository.findByLastPurchaseBefore(lastPurchase);}

    @Override
    public List<Customer> findByStatusId(Long statusId) {return customerRepository.findByStatusId(statusId);}

    @Override
    public List<Customer> findByEmailStatus(EmailStatus emailStatus) {return customerRepository.findByEmailStatus(emailStatus);}

    @Override
    public Optional<Customer> findByEmail(String email) {return customerRepository.findByEmail(email);}

    @Override
    public Customer updateLastPurchase(Long id, Date lastPurchase) {
        Customer customerBD = customerRepository.findById(id).orElse(null);
        if (customerBD == null) return null;
        customerBD.setLastPurchase(lastPurchase);
        return customerRepository.save(customerBD);
    }

    @Override
    public Customer updateStatus(Long id, Long statusId) {
        Customer customerBD = customerRepository.findById(id).orElse(null);
        if (customerBD == null) return null;
        customerBD.setStatusId(statusId);
        return customerRepository.save(customerBD);
    }

    @Override
    public Customer save(Customer customer) {return customerRepository.save(customer);}

    @Override
    public Customer update(Customer customer) {
        Customer customerBD = customerRepository.findById(customer.getId()).orElse(null);
        if (customerBD == null) return null;
        customerBD.setEntitie(customer.getEntitie());
        customerBD.setLastPurchase(customer.getLastPurchase());
        customerBD.setStatus(customer.getStatus());
        return customerRepository.save(customerBD);
    }

    @Override
    public Customer delete(Long id) {
        Customer customerBD = customerRepository.findById(id).orElse(null);
        if (customerBD == null) return null;
        customerRepository.delete(customerBD);
        return customerBD;
    }



}
