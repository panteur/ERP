package com.sysconnect.dev.erp_proyect.master_data_service.repository;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface BrandsRepository extends JpaRepository<Brands, Long> {


    List<Brands> findByNameContainsIgnoreCase(String name);

    Brands findByCodint(String codint);

    List<Brands> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<Brands> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);
}