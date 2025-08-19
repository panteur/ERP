package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Tax;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxServiceImpl implements TaxService{

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public Tax findById(Long id) {return taxRepository.findById(id).orElse(null);}

    @Override
    public List<Tax> findAll() {return taxRepository.findAll(); }

    @Override
    public List<Tax> findByAbrev(String abrev) {return taxRepository.findByAbrev(abrev);}

    @Override
    public Tax create(Tax tax) {return taxRepository.save(tax);}

    @Override
    public Tax update(Tax tax) {
        Tax taxDB = taxRepository.findById(tax.getId()).orElse(null);
        if(taxDB == null) return null;
        taxDB.setName(tax.getName());
        taxDB.setAbrev(tax.getAbrev());
        taxDB.setValue(tax.getValue());
        taxDB.setDescription(tax.getDescription());
        return taxRepository.save(taxDB);
    }

    @Override
    public Tax delete(Long id) {
        Tax taxDB = taxRepository.findById(id).orElse(null);
        if(taxDB == null) return null;
        taxRepository.delete(taxDB);
        return taxDB;
    }
}
