package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;

import java.util.List;

public interface EntitieService {

    public Entitie findById(Long id);
    public Entitie findByRut(String rut);
    public List<Entitie> findAll();
    public List<Entitie> findByEntitieType(String entitieType);

    public Entitie save(Entitie entitie);
    public Entitie update(Entitie entitie);
    public Entitie delete(Long id);
}
