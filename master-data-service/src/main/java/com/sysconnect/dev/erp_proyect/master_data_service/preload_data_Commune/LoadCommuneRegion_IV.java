package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_IV {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_IV() {

        Region region = regionRepository.findById(4L).orElse(null);

        //Copiapó 1
        if (!communeRepository.existsByRegion_IdAndName(4L, "Copiapó")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Copiapó");
            communeRepository.save(commune);
        }

        //Caldera 2
        if (!communeRepository.existsByRegion_IdAndName(4L, "Caldera")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Caldera");
            communeRepository.save(commune);
        }

        //Tierra Amarilla 3
        if (!communeRepository.existsByRegion_IdAndName(4L, "Tierra Amarilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tierra Amarilla");
            communeRepository.save(commune);
        }

        //Chañaral 4
        if (!communeRepository.existsByRegion_IdAndName(4L, "Chañaral")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chañaral");
            communeRepository.save(commune);
        }

        //Diego de Almagro 5
        if (!communeRepository.existsByRegion_IdAndName(4L, "Diego de Almagro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Diego de Almagro");
            communeRepository.save(commune);
        }

        //Vallenar 6
        if (!communeRepository.existsByRegion_IdAndName(4L, "Vallenar")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Vallenar");
            communeRepository.save(commune);
        }

        //Alto del Carmen 7
        if (!communeRepository.existsByRegion_IdAndName(4L, "Alto del Carmen")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Alto del Carmen");
            communeRepository.save(commune);
        }

        //Freirina 8
        if (!communeRepository.existsByRegion_IdAndName(4L, "Freirina")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Freirina");
            communeRepository.save(commune);
        }

        //Huasco 9
        if (!communeRepository.existsByRegion_IdAndName(4L, "Huasco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Huasco");
            communeRepository.save(commune);
        }

    }


}
