package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_II {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_II() {

        Region region = regionRepository.findById(2L).orElse(null);

        //Iquique
        if (!communeRepository.existsByRegion_IdAndName(2L, "Iquique")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Iquique");
            communeRepository.save(commune);
        }

        //Alto Hospicio
        if (!communeRepository.existsByRegion_IdAndName(2L, "Alto Hospicio")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Alto Hospicio");
            communeRepository.save(commune);
        }

        //Pozo Almonte
        if (!communeRepository.existsByRegion_IdAndName(2L, "Pozo Almonte")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pozo Almonte");
            communeRepository.save(commune);
        }

        //Camiña
        if (!communeRepository.existsByRegion_IdAndName(2L, "Camiña")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Camiña");
            communeRepository.save(commune);
        }

        //Colchane
        if (!communeRepository.existsByRegion_IdAndName(2L, "Colchane")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Colchane");
            communeRepository.save(commune);
        }

        //Huara
        if (!communeRepository.existsByRegion_IdAndName(2L, "Huara")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Huara");
            communeRepository.save(commune);
        }

        //Pica
        if (!communeRepository.existsByRegion_IdAndName(2L, "Pica")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pica");
            communeRepository.save(commune);
        }

    }
}
