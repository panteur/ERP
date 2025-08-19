package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegionServiceImpl implements RegionService{

    @Autowired
    private RegionRepository regionRepository;


    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> findByName(String name) {
        return regionRepository.findByNameContainsIgnore(name);
    }

    @Override
    public List<Region> findByOrdinal(String ordinal) {
        return regionRepository.findByOrdinal(ordinal);
    }

    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region update(Region region) {
        Region regionDB = regionRepository.findById(region.getId()).orElse(null);
        if (regionDB != null) {
            regionDB.setName(region.getName());
            regionDB.setOrdinal(region.getOrdinal());
            return regionRepository.save(regionDB);
        }
        return null;
    }

    @Override
    public Region delete(Long id) {
        Region regionDB = regionRepository.findById(id).orElse(null);
        if (regionDB != null) {
            regionRepository.delete(regionDB);
            return regionDB;
        }
        return null;
    }
}
