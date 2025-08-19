package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XII {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XII() {

        Region region = regionRepository.findById(12L).orElse(null);

        //Valdivia 1
        if (!communeRepository.existsByRegion_IdAndName(12L, "Valdivia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Valdivia");
            communeRepository.save(commune);
        }

        //Corral 2
        if (!communeRepository.existsByRegion_IdAndName(12L, "Corral")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Corral");
            communeRepository.save(commune);
        }

        //Lanco 3
        if (!communeRepository.existsByRegion_IdAndName(12L, "Lanco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lanco");
            communeRepository.save(commune);
        }

        //Los Lagos 4
        if (!communeRepository.existsByRegion_IdAndName(12L, "Los Lagos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Lagos");
            communeRepository.save(commune);
        }

        //Máfil 5
        if (!communeRepository.existsByRegion_IdAndName(12L, "Máfil")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Máfil");
            communeRepository.save(commune);
        }

        //Mariquina 6
        if (!communeRepository.existsByRegion_IdAndName(12L, "Mariquina")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Mariquina");
            communeRepository.save(commune);
        }

        //Paillaco 7
        if (!communeRepository.existsByRegion_IdAndName(12L, "Paillaco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Paillaco");
            communeRepository.save(commune);
        }

        //Panguipulli 8
        if (!communeRepository.existsByRegion_IdAndName(12L, "Panguipulli")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Panguipulli");
            communeRepository.save(commune);
        }

        //La Unión 9
        if (!communeRepository.existsByRegion_IdAndName(12L, "La Unión")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Unión");
            communeRepository.save(commune);
        }

        //Futrono 10
        if (!communeRepository.existsByRegion_IdAndName(12L, "Futrono")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Futrono");
            communeRepository.save(commune);
        }

        //Lago Ranco 11
        if (!communeRepository.existsByRegion_IdAndName(12L, "Lago Ranco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lago Ranco");
            communeRepository.save(commune);
        }

        //Río Bueno 12
        if (!communeRepository.existsByRegion_IdAndName(12L, "Río Bueno")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Río Bueno");
            communeRepository.save(commune);
        }

    }
}
