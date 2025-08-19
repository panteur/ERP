package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_III {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_III() {

        Region region = regionRepository.findById(3L).orElse(null);

        //Antofagasta 1
        if (!communeRepository.existsByRegion_IdAndName(3L, "Antofagasta")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Antofagasta");
            communeRepository.save(commune);
        }

        //Mejillones 2
        if (!communeRepository.existsByRegion_IdAndName(3L, "Mejillones")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Mejillones");
            communeRepository.save(commune);
        }

        //Sierra Gorda 3
        if (!communeRepository.existsByRegion_IdAndName(3L, "Sierra Gorda")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Sierra Gorda");
            communeRepository.save(commune);
        }

        //Taltal 4
        if (!communeRepository.existsByRegion_IdAndName(3L, "Taltal")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Taltal");
            communeRepository.save(commune);
        }

        //Calama 5
        if (!communeRepository.existsByRegion_IdAndName(3L, "Calama")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Calama");
            communeRepository.save(commune);
        }

        //Ollague 6
        if (!communeRepository.existsByRegion_IdAndName(3L, "Ollague")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ollague");
            communeRepository.save(commune);
        }

        //San Pedro de Atacama 7
        if (!communeRepository.existsByRegion_IdAndName(3L, "San Pedro de Atacama")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Pedro de Atacama");
            communeRepository.save(commune);
        }

        //Tocopilla 8
        if (!communeRepository.existsByRegion_IdAndName(3L, "Tocopilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tocopilla");
            communeRepository.save(commune);
        }

        //María Elena 9
        if (!communeRepository.existsByRegion_IdAndName(3L, "María Elena")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("María Elena");
            communeRepository.save(commune);
        }

    }


}
