package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;

import java.util.List;

public interface RegionService {

    public Region findById(Long id);
    public List<Region> findAll();
    public List<Region> findByName(String name);
    public List<Region> findByOrdinal(String ordinal);

    public Region create(Region region);
    public Region update(Region region);
    public Region delete(Long id);

}
