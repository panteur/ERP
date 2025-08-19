package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_CRITICITY;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Criticity;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CriticityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCriticity {

    @Autowired
    private CriticityRepository criticityRepository;

    public void loadCriticity() {

        Criticity criticity = new Criticity();
        if (!criticityRepository.existsByName("MINIMA")) {
            criticity.setCodint("CRT_MIN");
            criticity.setName("MINIMA");
            criticity.setDescription("Criticidad Minima");
            criticityRepository.save(criticity);
        }

        //BAJA
        criticity = new Criticity();
        if (!criticityRepository.existsByName("BAJA")) {
            criticity.setCodint("CRT_BAJ");
            criticity.setName("BAJA");
            criticity.setDescription("Criticidad Baja");
            criticityRepository.save(criticity);
        }

        //INTERMEDIA
        criticity = new Criticity();
        if (!criticityRepository.existsByName("INTERMEDIA")) {
            criticity.setCodint("CRT_INT");
            criticity.setName("INTERMEDIA");
            criticity.setDescription("Criticidad Intermedia");
            criticityRepository.save(criticity);
        }

        //ALTA
        criticity = new Criticity();
        if (!criticityRepository.existsByName("ALTA")) {
            criticity.setCodint("CRT_ALT");
            criticity.setName("ALTA");
            criticity.setDescription("Criticidad Alta");
            criticityRepository.save(criticity);
        }

        //CRITICA
        criticity = new Criticity();
        if (!criticityRepository.existsByName("CRITICA")) {
            criticity.setCodint("CRT_CRI");
            criticity.setName("CRITICA");
            criticity.setDescription("Criticidad Critica");
            criticityRepository.save(criticity);
        }

    }

}
