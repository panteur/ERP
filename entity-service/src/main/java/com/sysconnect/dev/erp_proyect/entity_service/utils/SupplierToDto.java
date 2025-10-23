package com.sysconnect.dev.erp_proyect.entity_service.utils;

import com.sysconnect.dev.erp_proyect.entity_service.dto.SupplierCompanyDto;
import com.sysconnect.dev.erp_proyect.entity_service.dto.SupplierPersonDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Company;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Supplier;
import com.sysconnect.dev.erp_proyect.entity_service.service.CompanyService;
import com.sysconnect.dev.erp_proyect.entity_service.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class SupplierToDto {

    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Bean
    public SupplierPersonDto toPersonDto(Supplier supplier) {
        Entitie entitieBD = supplier.getEntitie();
        Person personDB = personService.findByEntitie_Id(entitieBD.getId());
        SupplierPersonDto supplierPersonDto = new SupplierPersonDto().builder()
                .id(supplier.getEntitie().getId())
                .rut(entitieBD.getRut())
                .names(personDB.getNames())
                .lastNames(personDB.getLastNames())
                .birthDate(personDB.getBirthDate())
                .sex(personDB.getSex())
                .nationality(personDB.getNationality())
                .statusId(supplier.getStatusId())
                .firstPurchase(supplier.getFirstPurchase())
                .payDay(supplier.getPayDay())
                .paymentMethod(supplier.getPaymentMethod())
                .paymentShape(supplier.getPaymentShape())
                .build();
        return supplierPersonDto;
    }

    @Bean
    public SupplierCompanyDto toCompanyDto(Supplier supplier) {
        Entitie entitieBD = supplier.getEntitie();
        Company company = companyService.findByEntitieId(entitieBD.getId());
        SupplierCompanyDto supplierCompanyDto = new SupplierCompanyDto().builder()
                .id(supplier.getEntitie().getId())
                .rut(entitieBD.getRut())
                .socialRazon(company.getSocialRazon())
                .fantasyName(company.getFantasyName())
                .giros(company.getGiros())
                .statusId(supplier.getStatusId())
                .parent(supplier.getParent())
                .firstPurchase(supplier.getFirstPurchase())
                .payDay(supplier.getPayDay())
                .paymentMethod(supplier.getPaymentMethod())
                .paymentShape(supplier.getPaymentShape())
                .build();
        return supplierCompanyDto;
    }

    @Bean
    public List<SupplierPersonDto> toPersonList(List<Supplier> list) {
        List<SupplierPersonDto> dtoList = new ArrayList<>();
        for (Supplier supplier : list) {
            SupplierPersonDto supplierPersonDto = toPersonDto(supplier);
            dtoList.add(supplierPersonDto);
        }
        return dtoList;
    }

    @Bean
    public List<SupplierCompanyDto> toCompanyList(List<Supplier> list) {
        List<SupplierCompanyDto> dtoList = new ArrayList<>();
        for (Supplier supplier : list) {
            SupplierCompanyDto supplierCompanyDto = toCompanyDto(supplier);
            dtoList.add(supplierCompanyDto);
        }
        return dtoList;
        }

}
