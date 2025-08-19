package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_V {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_V() {

        Region region = regionRepository.findById(5L).orElse(null);

        //La Serena 1
        if (!communeRepository.existsByRegion_IdAndName(5L, "La Serena")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Serena");
            communeRepository.save(commune);
        }

        //Coquimbo 2
        if (!communeRepository.existsByRegion_IdAndName(5L, "Coquimbo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coquimbo");
            communeRepository.save(commune);
        }

        //Andacollo 3
        if (!communeRepository.existsByRegion_IdAndName(5L, "Andacollo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Andacollo");
            communeRepository.save(commune);
        }

        //La Higuera 4
        if (!communeRepository.existsByRegion_IdAndName(5L, "La Higuera")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Higuera");
            communeRepository.save(commune);
        }

        //Paihuano 5
        if (!communeRepository.existsByRegion_IdAndName(5L, "Paihuano")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Paihuano");
            communeRepository.save(commune);
        }

        //Vicuña 6
        if (!communeRepository.existsByRegion_IdAndName(5L, "Vicuña")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Vicuña");
            communeRepository.save(commune);
        }

        //Illapel 7
        if (!communeRepository.existsByRegion_IdAndName(5L, "Illapel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Illapel");
            communeRepository.save(commune);
        }

        //Canela 8
        if (!communeRepository.existsByRegion_IdAndName(5L, "Canela")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Canela");
            communeRepository.save(commune);
        }

        //Los Vilos 9
        if (!communeRepository.existsByRegion_IdAndName(5L, "Los Vilos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Vilos");
            communeRepository.save(commune);
        }

        //Salamanca 10
        if (!communeRepository.existsByRegion_IdAndName(5L, "Salamanca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Salamanca");
            communeRepository.save(commune);
        }

        //Ovalle 11
        if (!communeRepository.existsByRegion_IdAndName(5L, "Ovalle")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ovalle");
            communeRepository.save(commune);
        }

        //Combarbalá 12
        if (!communeRepository.existsByRegion_IdAndName(5L, "Combarbalá")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Combarbalá");
            communeRepository.save(commune);
        }

        //Monte Patria 13
        if (!communeRepository.existsByRegion_IdAndName(5L, "Monte Patria")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Monte Patria");
            communeRepository.save(commune);
        }

        //Punitaqui 14
        if (!communeRepository.existsByRegion_IdAndName(5L, "Punitaqui")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Punitaqui");
            communeRepository.save(commune);
        }

        //Río Hurtado 15
        if (!communeRepository.existsByRegion_IdAndName(5L, "Río Hurtado")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Río Hurtado");
            communeRepository.save(commune);
        }

    }
}
