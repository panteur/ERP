package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Company;

import java.util.List;

public interface CompanyService {

    public Company findById(Long id);
    public Company findByEntitieId(Long id);
    public List<Company> findAll();

    public Company save(Company company);
    public Company update(Company company);
    public Company delete(Long id);
}
