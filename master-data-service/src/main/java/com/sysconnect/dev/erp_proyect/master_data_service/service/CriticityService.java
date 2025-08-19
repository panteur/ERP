package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Criticity;

import java.sql.Timestamp;
import java.util.List;

public interface CriticityService {

    public Criticity findById(Long id);//
    public Criticity findByCodint(String codint);//
    public Long countCriticity(Long id);

    public List<Criticity> findAll();//
    public List<Criticity> findByNameContainsIgnoreCase(String name);//
    public List<Criticity> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);
    public List<Criticity> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    public Criticity createCriticity(Criticity criticity);
    public Criticity updateCriticity(Criticity criticity);
    public Criticity deleteCriticity(Long id);


}
