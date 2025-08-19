package com.sysconnect.dev.erp_proyect.master_data_service.service;




import com.sysconnect.dev.erp_proyect.master_data_service.entity.Brands;

import java.sql.Timestamp;
import java.util.List;

public interface BrandsService {

    // Single result
    public Brands findById(Long id); //
    public Brands findByCodint(String codint);
    public long countById(Long id);

    // List result
    public List<Brands> findAll(); //
    public List<Brands> findByNameContainsIgnoreCase(String name); //
    public List<Brands> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd); //
    public List<Brands> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd); //

    // Crud entity
    public Brands saveBrands(Brands brands);
    public Brands updateBrands(Brands brands);
    public Brands deleteBrands(Long id);

}
