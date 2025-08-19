package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_CRITICITY.LoadCriticity;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CriticityRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Criticity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CriticityServiceImpl implements CriticityService {

    @Autowired
    private CriticityRepository criticityRepository;

    @Autowired
    private LoadCriticity loadCriticity;


    @Override
    public Criticity findById(Long id) {
        return criticityRepository.findById(id).orElse(null);
    }

    @Override
    public Criticity findByCodint(String codint) {
        return criticityRepository.findByCodint(codint);
    }

    @Override
    public Long countCriticity(Long id) {
        return criticityRepository.countById(id);
    }

    @Override
    public List<Criticity> findAll() {
        return criticityRepository.findAll();
    }

    @Override
    public List<Criticity> findByNameContainsIgnoreCase(String name) {
        return criticityRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Criticity> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return criticityRepository.findByCreateAtBetween(createAtStart,createAtEnd);
    }

    @Override
    public List<Criticity> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return criticityRepository.findByUpdateAtBetween(updateAtStart,updateAtEnd);
    }

    @Override
    public Criticity createCriticity(Criticity criticity) {
        return criticityRepository.save(criticity);
    }

    @Override
    public Criticity updateCriticity(Criticity criticity) {
        Criticity criticityDB = criticityRepository.findById(criticity.getId()).orElse(null);
        if (criticityDB != null)  {
            criticityDB.setName(criticity.getName());
            criticityDB.setCodint(criticity.getCodint());
            criticityDB.setDescription(criticity.getDescription());

            return criticityRepository.save(criticityDB);
        }
        return null;
    }

    @Override
    public Criticity deleteCriticity(Long id) {
        Criticity criticityDB = criticityRepository.findById(id).orElse(null);
        if (criticityDB == null) return null;
        criticityRepository.delete(criticityDB);
        return criticityDB;
    }


}
