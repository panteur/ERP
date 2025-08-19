package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Brands;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BrandsServiceImpl implements BrandsService{

    @Autowired
    private BrandsRepository brandsRepository;

    @Override
    public Brands findById(Long id) {return brandsRepository.findById(id).orElse(null);}

    @Override
    public Brands findByCodint(String codint) {
        return brandsRepository.findByCodint(codint);
    }

    @Override
    public long countById(Long id) {
        return brandsRepository.countById(id);
    }

    @Override
    public List<Brands> findAll() {
        return brandsRepository.findAll();
    }

    @Override
    public List<Brands> findByNameContainsIgnoreCase(String name) {
        return brandsRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Brands> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return brandsRepository.findByCreateAtBetween(createAtStart,createAtEnd);
    }

    @Override
    public List<Brands> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return brandsRepository.findByUpdateAtBetween(updateAtStart,updateAtEnd);
    }

    @Override
    public Brands saveBrands(Brands brands) {
        return brandsRepository.save(brands);
    }

    @SuppressWarnings("null")
    @Override
    public Brands updateBrands(Brands brands) {
        Brands brandsDB = brandsRepository.findById(brands.getId()).orElse(null);
        if (brandsDB != null) {
            brandsDB.setName(brands.getName());
            brandsDB.setCodint(brands.getCodint());
            brandsDB.setDescription(brands.getDescription());
            return brandsRepository.save(brandsDB);
        }
        return null;

    }

    @SuppressWarnings("null")
    @Override
    public Brands deleteBrands(Long id) {
        Brands brandsDB = brandsRepository.findById(id).orElse(null);
        if (brandsDB != null) {
            brandsRepository.delete(brandsDB);
            return brandsDB;
        }
        return null;
    }
}
