package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_IX {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_IX() {

        Region region = regionRepository.findById(9L).orElse(null);

    //Chillán 1
        if (!communeRepository.existsByRegion_IdAndName(9L, "Chillán")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chillán");
            communeRepository.save(commune);
        }

    //Bulnes 2
        if (!communeRepository.existsByRegion_IdAndName(9L, "Bulnes")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Bulnes");
            communeRepository.save(commune);
        }

        //Chillan Viejo 3
        if (!communeRepository.existsByRegion_IdAndName(9L, "Chillan Viejo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chillan Viejo");
            communeRepository.save(commune);
        }

        //El Carmen 4
        if (!communeRepository.existsByRegion_IdAndName(9L, "El Carmen")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("El Carmen");
            communeRepository.save(commune);
        }

        //Pemuco 5
        if (!communeRepository.existsByRegion_IdAndName(9L, "Pemuco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pemuco");
            communeRepository.save(commune);
        }

        //Pinto 6
        if (!communeRepository.existsByRegion_IdAndName(9L, "Pinto")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pinto");
            communeRepository.save(commune);
        }

        //Quillón 7
        if (!communeRepository.existsByRegion_IdAndName(9L, "Quillón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quillón");
            communeRepository.save(commune);
        }

        //San Ignacio 8
        if (!communeRepository.existsByRegion_IdAndName(9L, "San Ignacio")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Ignacio");
            communeRepository.save(commune);
        }

        //Yungay 9
        if (!communeRepository.existsByRegion_IdAndName(9L, "Yungay")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Yungay");
            communeRepository.save(commune);
        }

        //Quirihue 10
        if (!communeRepository.existsByRegion_IdAndName(9L, "Quirihue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quirihue");
            communeRepository.save(commune);
        }

        //Cobquecura 11
        if (!communeRepository.existsByRegion_IdAndName(9L, "Cobquecura")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cobquecura");
            communeRepository.save(commune);
        }

        //Coelemu 12
        if (!communeRepository.existsByRegion_IdAndName(9L, "Coelemu")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coelemu");
            communeRepository.save(commune);
        }

        //Ninhue 13
        if (!communeRepository.existsByRegion_IdAndName(9L, "Ninhue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ninhue");
            communeRepository.save(commune);
        }

        //Portezuelo 14
        if (!communeRepository.existsByRegion_IdAndName(9L, "Portezuelo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Portezuelo");
            communeRepository.save(commune);
        }

        //Ránquil 15
        if (!communeRepository.existsByRegion_IdAndName(9L, "Ránquil")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ránquil");
            communeRepository.save(commune);
        }

        //Treguaco 16
        if (!communeRepository.existsByRegion_IdAndName(9L, "Treguaco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Treguaco");
            communeRepository.save(commune);
        }

        //San Carlos 17
        if (!communeRepository.existsByRegion_IdAndName(9L, "San Carlos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Carlos");
            communeRepository.save(commune);
        }

        //Coihueco 18
        if (!communeRepository.existsByRegion_IdAndName(9L, "Coihueco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coihueco");
            communeRepository.save(commune);
        }

        //Ñiquén 19
        if (!communeRepository.existsByRegion_IdAndName(9L, "Ñiquén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ñiquén");
            communeRepository.save(commune);
        }

        //San Fabián 20
        if (!communeRepository.existsByRegion_IdAndName(9L, "San Fabián")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Fabián");
            communeRepository.save(commune);
        }

        //San Nicolás 21
        if (!communeRepository.existsByRegion_IdAndName(9L, "San Nicolás")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Nicolás");
            communeRepository.save(commune);
        }
    }

}
