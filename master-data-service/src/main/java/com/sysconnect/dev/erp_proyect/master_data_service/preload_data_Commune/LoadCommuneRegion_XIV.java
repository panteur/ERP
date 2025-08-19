package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XIV {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XIV() {

        Region region = regionRepository.findById(14L).orElse(null);

        //Coyhaique 1
        if (!communeRepository.existsByRegion_IdAndName(14L, "Coyhaique")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coyhaique");
            communeRepository.save(commune);
        }

        //Lago Verde 2
        if (!communeRepository.existsByRegion_IdAndName(14L, "Lago Verde")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lago Verde");
            communeRepository.save(commune);
        }

        //Aysén 3
        if (!communeRepository.existsByRegion_IdAndName(14L, "Aysén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Aysén");
            communeRepository.save(commune);
        }

        //Cisnes 4
        if (!communeRepository.existsByRegion_IdAndName(14L, "Cisnes")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cisnes");
            communeRepository.save(commune);
        }

        //Guaitecas 5
        if (!communeRepository.existsByRegion_IdAndName(14L, "Guaitecas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Guaitecas");
            communeRepository.save(commune);
        }

        //Cochrane 6
        if (!communeRepository.existsByRegion_IdAndName(14L, "Cochrane")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cochrane");
            communeRepository.save(commune);
        }

        //O'Higgins 7
        if (!communeRepository.existsByRegion_IdAndName(14L, "O'Higgins")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("O'Higgins");
            communeRepository.save(commune);
        }

        //Tortel 8
        if (!communeRepository.existsByRegion_IdAndName(14L, "Tortel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tortel");
            communeRepository.save(commune);
        }

        //Chile Chico 9
        if (!communeRepository.existsByRegion_IdAndName(14L, "Chile Chico")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chile Chico");
            communeRepository.save(commune);
        }

        //Río Ibáñez 10
        if (!communeRepository.existsByRegion_IdAndName(14L, "Río Ibáñez")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Río Ibáñez");
            communeRepository.save(commune);
        }

    }

}
