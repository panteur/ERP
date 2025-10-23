package com.sysconnect.dev.erp_proyect.entity_service.utils;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerCompanyDto;
import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerPersonDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Company;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import com.sysconnect.dev.erp_proyect.entity_service.service.CompanyService;
import com.sysconnect.dev.erp_proyect.entity_service.service.PersonService;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class CustomerToDto {

    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Bean
    public CustomerPersonDto toPersonDto(Customer customer) {
        Entitie EntitieBD = customer.getEntitie();
        Person personDB = personService.findByEntitie_Id(EntitieBD.getId());
        CustomerPersonDto customerPersonDto = new CustomerPersonDto().builder()
                .id(customer.getEntitie().getId())
                .rut(EntitieBD.getRut())
                .names(personDB.getNames())
                .lastNames(personDB.getLastNames())
                .birthDate(personDB.getBirthDate())
                .sex(personDB.getSex())
                .nationality(personDB.getNationality())
                .statusId(customer.getStatusId())
                .parent(customer.getParent())
                .lastPurchase(customer.getLastPurchase())
                .email(customer.getEmail())
                .build();
        return customerPersonDto;
    }

    @Bean
    public CustomerCompanyDto toCompanyDto(Customer customer) {
        Entitie EntitieBD = customer.getEntitie();
        Company companyDB = companyService.findByEntitieId(EntitieBD.getId());
        CustomerCompanyDto customerCompanyDto = new CustomerCompanyDto().builder()
                .id(customer.getEntitie().getId())
                .rut(EntitieBD.getRut())
                .socialRazon(companyDB.getSocialRazon())
                .fantasyName(companyDB.getFantasyName())
                .giros(companyDB.getGiros())
                .statusId(customer.getStatusId())
                .parent(customer.getParent())
                .lastPurchase(customer.getLastPurchase())
                .email(customer.getEmail())
                .build();
        return customerCompanyDto;
    }

    @Bean
    public List<CustomerPersonDto> toPersonList(List<Customer> list) {
        List<CustomerPersonDto> dtoList = new ArrayList<>();
        for (Customer customer : list) {
            CustomerPersonDto customerPersonDto = toPersonDto(customer);
            dtoList.add(customerPersonDto);
        }
        return dtoList;
    }

    @Bean
    public List<CustomerCompanyDto> toCompanyList(List<Customer> list) {
        List<CustomerCompanyDto> dtoList = new ArrayList<>();
        for (Customer customer : list) {
            CustomerCompanyDto customerCompanyDto = toCompanyDto(customer);
            dtoList.add(customerCompanyDto);
        }
        return dtoList;
    }


}
