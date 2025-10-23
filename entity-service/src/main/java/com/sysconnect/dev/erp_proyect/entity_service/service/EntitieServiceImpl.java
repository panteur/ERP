package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import com.sysconnect.dev.erp_proyect.entity_service.repository.EntitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.valueOf;

@Service
public class EntitieServiceImpl implements EntitieService{

    @Autowired
    private EntitieRepository entitieRepository;

    @Override
    public Entitie findById(Long id) {return entitieRepository.findById(id).orElse(null);}

    @Override
    public Entitie findByRut(String rut) {return entitieRepository.findByRut(rut).orElse(null);}

    @Override
    public List<Entitie> findAll() {return entitieRepository.findAll();}

    @Override
    public List<Entitie> findByEntitieType(String entitieType) {return entitieRepository.findByEntitieType(valueOf(entitieType));}

    @Override
    public Entitie save(Entitie entitie) {return entitieRepository.save(entitie);}

    @Override
    public Entitie update(Entitie entitie) {
        Entitie entitieBD = entitieRepository.findById(entitie.getId()).orElse(null);
        if (entitieBD == null) return null;
        entitieBD.setRut(entitie.getRut());
        entitieBD.setEntitieType(entitie.getEntitieType());
        return entitieRepository.save(entitieBD);
    }

    @Override
    public Entitie delete(Long id) {
        Entitie entitieBD = entitieRepository.findById(id).orElse(null);
        if (entitieBD == null) return null;
        entitieRepository.delete(entitieBD);
        return entitieBD;
    }
}
