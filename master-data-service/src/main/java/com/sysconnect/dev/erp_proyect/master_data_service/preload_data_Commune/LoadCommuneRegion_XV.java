package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XV {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XV() {

        Region region = regionRepository.findById(15L).orElse(null);

        //Punta Arenas 1
        if (!communeRepository.existsByRegion_IdAndName(15L, "Punta Arenas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Punta Arenas");
            communeRepository.save(commune);
        }

        //Laguna Blanca 2
        if (!communeRepository.existsByRegion_IdAndName(15L, "Laguna Blanca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Laguna Blanca");
            communeRepository.save(commune);
        }

        //Río Verde 3
        if (!communeRepository.existsByRegion_IdAndName(15L, "Río Verde")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Río Verde");
            communeRepository.save(commune);
        }

        //San Gregorio 4
        if (!communeRepository.existsByRegion_IdAndName(15L, "San Gregorio")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Gregorio");
            communeRepository.save(commune);
        }

        //Cabo de Hornos 5
        if (!communeRepository.existsByRegion_IdAndName(15L, "Cabo de Hornos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cabo de Hornos");
            communeRepository.save(commune);
        }

        //Antártica 6
        if (!communeRepository.existsByRegion_IdAndName(15L, "Antártica")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Antártica");
            communeRepository.save(commune);
        }

        //Porvenir 7
        if (!communeRepository.existsByRegion_IdAndName(15L, "Porvenir")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Porvenir");
            communeRepository.save(commune);
        }

        //Primavera 8
        if (!communeRepository.existsByRegion_IdAndName(15L, "Primavera")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Primavera");
            communeRepository.save(commune);
        }

        //Timaukel 9
        if (!communeRepository.existsByRegion_IdAndName(15L, "Timaukel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Timaukel");
            communeRepository.save(commune);
        }

        //Natales 10
        if (!communeRepository.existsByRegion_IdAndName(15L, "Natales")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Natales");
            communeRepository.save(commune);
        }

        //Torres del Paine 11
        if (!communeRepository.existsByRegion_IdAndName(15L, "Torres del Paine")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Torres del Paine");
            communeRepository.save(commune);
        }

    }

}
