package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;

import java.util.List;

public interface CommuneService {

    public Commune findById(Long id);
    public List<Commune> findAll();
    public List<Commune> findByName(String name);
    public List<Commune> findByRegionId(Long id);

    public Commune create(Commune commune);
    public Commune update(Commune commune);
    public Commune delete(Long id);

}
