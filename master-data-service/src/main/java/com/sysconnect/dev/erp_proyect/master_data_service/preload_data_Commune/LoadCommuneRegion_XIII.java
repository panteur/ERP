package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XIII {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XIII() {

        Region region = regionRepository.findById(13L).orElse(null);

        //Puerto Montt 1
        if (!communeRepository.existsByRegion_IdAndName(13L, "Puerto Montt")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puerto Montt");
            communeRepository.save(commune);
        }

        //Calbuco 2
        if (!communeRepository.existsByRegion_IdAndName(13L, "Calbuco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Calbuco");
            communeRepository.save(commune);
        }

        //Cochamó 3
        if (!communeRepository.existsByRegion_IdAndName(13L, "Cochamó")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cochamó");
            communeRepository.save(commune);
        }

        //Fresia 4
        if (!communeRepository.existsByRegion_IdAndName(13L, "Fresia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Fresia");
            communeRepository.save(commune);
        }

        //Frutillar 5
        if (!communeRepository.existsByRegion_IdAndName(13L, "Frutillar")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Frutillar");
            communeRepository.save(commune);
        }

        //Los Muermos 6
        if (!communeRepository.existsByRegion_IdAndName(13L, "Los Muermos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Muermos");
            communeRepository.save(commune);
        }

        //Llanquihue 7
        if (!communeRepository.existsByRegion_IdAndName(13L, "Llanquihue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Llanquihue");
            communeRepository.save(commune);
        }

        //Maullín 8
        if (!communeRepository.existsByRegion_IdAndName(13L, "Maullín")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Maullín");
            communeRepository.save(commune);
        }

        //Puerto Varas 9
        if (!communeRepository.existsByRegion_IdAndName(13L, "Puerto Varas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puerto Varas");
            communeRepository.save(commune);
        }

        //Castro 10
        if (!communeRepository.existsByRegion_IdAndName(13L, "Castro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Castro");
            communeRepository.save(commune);
        }

        //Ancud 11
        if (!communeRepository.existsByRegion_IdAndName(13L, "Ancud")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ancud");
            communeRepository.save(commune);
        }

        //Chonchi 12
        if (!communeRepository.existsByRegion_IdAndName(13L, "Chonchi")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chonchi");
            communeRepository.save(commune);
        }

        //Curaco de Vélez 13
        if (!communeRepository.existsByRegion_IdAndName(13L, "Curaco de Vélez")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curaco de Vélez");
            communeRepository.save(commune);
        }

        //Dalcahue 14
        if (!communeRepository.existsByRegion_IdAndName(13L, "Dalcahue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Dalcahue");
            communeRepository.save(commune);
        }

        //Puqueldón 15
        if (!communeRepository.existsByRegion_IdAndName(13L, "Puqueldón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puqueldón");
            communeRepository.save(commune);
        }

        //Queilén 16
        if (!communeRepository.existsByRegion_IdAndName(13L, "Queilén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Queilén");
            communeRepository.save(commune);
        }

        //Quellón 17
        if (!communeRepository.existsByRegion_IdAndName(13L, "Quellón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quellón");
            communeRepository.save(commune);
        }

        //Quemchi 18
        if (!communeRepository.existsByRegion_IdAndName(13L, "Quemchi")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quemchi");
            communeRepository.save(commune);
        }

        //Quinchao 19
        if (!communeRepository.existsByRegion_IdAndName(13L, "Quinchao")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quinchao");
            communeRepository.save(commune);
        }

        //Osorno 20
        if (!communeRepository.existsByRegion_IdAndName(13L, "Osorno")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Osorno");
            communeRepository.save(commune);
        }

        //Puerto Octay 21
        if (!communeRepository.existsByRegion_IdAndName(13L, "Puerto Octay")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puerto Octay");
            communeRepository.save(commune);
        }

        //Purranque 22
        if (!communeRepository.existsByRegion_IdAndName(13L, "Purranque")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Purranque");
            communeRepository.save(commune);
        }

        //Puyehue 23
        if (!communeRepository.existsByRegion_IdAndName(13L, "Puyehue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puyehue");
            communeRepository.save(commune);
        }

        //Rio negro 24
        if (!communeRepository.existsByRegion_IdAndName(13L, "Rio negro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Rio negro");
            communeRepository.save(commune);
        }

        //San Juan de la costa 25
        if (!communeRepository.existsByRegion_IdAndName(13L, "San Juan de la costa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Juan de la costa");
            communeRepository.save(commune);
        }

        //San Pablo 26
        if (!communeRepository.existsByRegion_IdAndName(13L, "San Pablo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Pablo");
            communeRepository.save(commune);
        }

        //Chaitén 27
        if (!communeRepository.existsByRegion_IdAndName(13L, "Chaitén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chaitén");
            communeRepository.save(commune);
        }

        //Futaleufú 28
        if (!communeRepository.existsByRegion_IdAndName(13L, "Futaleufú")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Futaleufú");
            communeRepository.save(commune);
        }

        //Hualaihué 29
        if (!communeRepository.existsByRegion_IdAndName(13L, "Hualaihué")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Hualaihué");
            communeRepository.save(commune);
        }

        //Palena 30
        if (!communeRepository.existsByRegion_IdAndName(13L, "Palena")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Palena");
            communeRepository.save(commune);


        }
    }
}