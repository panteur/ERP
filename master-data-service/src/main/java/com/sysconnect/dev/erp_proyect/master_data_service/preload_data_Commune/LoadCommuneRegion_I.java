package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_I {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository  regionRepository;


    public void LoadCommuneRegion_I() {

        Region region = regionRepository.findById(1L).orElse(null);

        //Arica
        if (!communeRepository.existsByRegion_IdAndName(1L, "Arica")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Arica");
            communeRepository.save(commune);
        }


        if (!communeRepository.existsByRegion_IdAndName(1L, "Camarones")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Camarones");
            communeRepository.save(commune);
        }

        //Putre
        if (!communeRepository.existsByRegion_IdAndName(1L, "Putre")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Putre");
            communeRepository.save(commune);
        }

        //General Lagos
        if (!communeRepository.existsByRegion_IdAndName(1L, "General Lagos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("General Lagos");
            communeRepository.save(commune);
        }

    }
}
