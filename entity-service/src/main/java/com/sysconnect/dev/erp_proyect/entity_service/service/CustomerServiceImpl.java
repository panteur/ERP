package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerCreateDto;
import com.sysconnect.dev.erp_proyect.entity_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import com.sysconnect.dev.erp_proyect.entity_service.feignclients.StatusFeignClient;
import com.sysconnect.dev.erp_proyect.entity_service.model.Status;
import com.sysconnect.dev.erp_proyect.entity_service.repository.CustomerRepository;
import com.sysconnect.dev.erp_proyect.entity_service.repository.EntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntitieRepository entitieRepository;

    @Autowired
    private StatusFeignClient feignClient;


    @Override
    public Customer findByEntitie_Id(Long id) {return customerRepository.findByEntitie_Id(id).orElse(null);}

    @Override
    public List<Customer> findByNamesOrLastNamesContaining(String searchText) { return customerRepository.findByNamesOrLastNamesContaining(searchText); }

    @Override
    public List<Customer> findByStatusId(Long statusId) {return customerRepository.findByStatusId(statusId);}

    @Override
    public List<Customer> findByBirthDate(Date birthDate) {return customerRepository.findByBirthDate(birthDate);}

    @Override
    public List<Customer> findBySex(Sex sex) {return customerRepository.findBySex(sex);}

    @Override
    public List<Customer> findByFirstPurchaseBetween(Date firstPurchaseStart, Date firstPurchaseEnd) {return customerRepository.findByFirstPurchaseBetween(firstPurchaseStart,firstPurchaseEnd); }

    @Override
    public List<Customer> findByLastPurchaseBetween(Date lastPurchaseStart, Date lastPurchaseEnd) {return customerRepository.findByLastPurchaseBetween(lastPurchaseStart,lastPurchaseEnd); }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public MessageDto save(CustomerCreateDto dto) {
        Entitie entitieDB = entitieRepository.findByRut(dto.getRut()).orElse(null);
        if(entitieDB == null) {
            entitieDB = entitieRepository.save(Entitie.builder()
                    .rut(dto.getRut())
                    .entitieType(EntitieType.valueOf(dto.getEntityType()))
                    .build());
        }
        Customer customerDB = new Customer();
        customerDB.setEntitie(entitieDB);
        customerDB.setNames(dto.getNames());
        customerDB.setLastNames(dto.getLastNames());
        customerDB.setBirthDate(dto.getBirthDate());
        customerDB.setSex(dto.getSex());
        Status status = feignClient.getStatusByCodint("STS_CLI_VIGENTE").getBody();
        customerDB.setStatus(status);
        customerDB.setStatusId(status.getId());
        customerRepository.save(customerDB);
        return new MessageDto("Cliente '" + dto.getNames() + " " + dto.getLastNames() + " creado exitosamente");

    }

    @Override
    public Customer update(Customer customer) {
        Customer customerDB = customerRepository.findById(customer.getId()).orElse(null);
        if (customerDB == null) return null;
        customerDB.setNames(customer.getNames());
        customerDB.setLastNames(customer.getLastNames());
        customerDB.setStatusId(customer.getStatusId());
        customerDB.setBirthDate(customer.getBirthDate());
        customerDB.setSex(customer.getSex());
        customerDB.setFirstPurchase(customer.getFirstPurchase());
        customerDB.setLastPurchase(customer.getLastPurchase());
        return customerRepository.save(customerDB);
    }

    @Override
    public MessageDto delete(Long id) {
        Customer customerDB = customerRepository.findById(id).orElse(null);
        if (customerDB == null ) return null;
        customerRepository.delete(customerDB);
        return new MessageDto("Cliente '" + customerDB.getNames()+" "+customerDB.getLastNames()+ " eliminado exitosamente");
    }
}
