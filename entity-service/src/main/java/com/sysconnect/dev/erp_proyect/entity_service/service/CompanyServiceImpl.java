package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sysconnect.dev.erp_proyect.entity_service.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company findById(Long id) {return companyRepository.findById(id).orElse(null);}

    @Override
    public Company findByEntitieId(Long id) {return companyRepository.findByEntitie_Id(id).orElse(null);}

    @Override
    public List<Company> findAll() {return companyRepository.findAll();}

    @Override
    public Company save(Company company) {return companyRepository.save(company);}

    @Override
    public Company update(Company company) {
        Company companyBD = companyRepository.findById(company.getId()).orElse(null);
        if (companyBD == null) return null;
        companyBD.setEntitie(company.getEntitie());
        companyBD.setGiros(company.getGiros());
        companyBD.setSocialRazon(company.getSocialRazon());
        companyBD.setFantasyName(company.getFantasyName());
        return companyRepository.save(companyBD);
    }

    @Override
    public Company delete(Long id) {
        Company companyBD = companyRepository.findById(id).orElse(null);
        if (companyBD == null) return null;
        companyRepository.delete(companyBD);
        return companyBD;
    }



}
