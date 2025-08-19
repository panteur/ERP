package com.sysconnect.dev.erp_proyect.master_data_service.service;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneServiceImpl implements CommuneService{

    @Autowired
    private CommuneRepository communeRepository;


    @Override
    public Commune findById(Long id) {
        return communeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commune> findAll() {
        return communeRepository.findAll();
    }


    @Override
    public List<Commune> findByName(String name) {
        return communeRepository.findByNameContains(name);
    }

    @Override
    public List<Commune> findByRegionId(Long id) {return communeRepository.findByRegion_Id(id);}

    @Override
    public Commune create(Commune commune) {
        return communeRepository.save(commune);
    }

    @Override
    public Commune update(Commune commune) {
        Commune communeDB = communeRepository.findById(commune.getId()).orElse(null);
        if (communeDB != null) {
            communeDB.setName(commune.getName());
            communeDB.setRegion(commune.getRegion());
            return communeRepository.save(communeDB);
        }
        return null;
    }

    @Override
    public Commune delete(Long id) {
        Commune communeDB = communeRepository.findById(id).orElse(null);
        if (communeDB != null) {
            communeRepository.delete(communeDB);
            return communeDB;
        }
        return null;
    }
}
