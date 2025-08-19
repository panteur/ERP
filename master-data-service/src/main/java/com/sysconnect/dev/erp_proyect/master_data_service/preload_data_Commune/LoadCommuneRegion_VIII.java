package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_VIII {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_VIII() {

        Region region = regionRepository.findById(8L).orElse(null);

        //Talca 1
        if (!communeRepository.existsByRegion_IdAndName(8L, "Talca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Talca");
            communeRepository.save(commune);
        }

        //Constitución 2
        if (!communeRepository.existsByRegion_IdAndName(8L, "Constitución")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Constitución");
            communeRepository.save(commune);
        }

        //Curepto 3
        if (!communeRepository.existsByRegion_IdAndName(8L, "Curepto")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curepto");
            communeRepository.save(commune);
        }

        //Empedrado 4
        if (!communeRepository.existsByRegion_IdAndName(8L, "Empedrado")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Empedrado");
            communeRepository.save(commune);
        }

        //Maule 5
        if (!communeRepository.existsByRegion_IdAndName(8L, "Maule")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Maule");
            communeRepository.save(commune);
        }

        //Pelarco 6
        if (!communeRepository.existsByRegion_IdAndName(8L, "Pelarco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pelarco");
            communeRepository.save(commune);
        }

        //Pencahue 7
        if (!communeRepository.existsByRegion_IdAndName(8L, "Pencahue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pencahue");
            communeRepository.save(commune);
        }

        //Río Claro 8
        if (!communeRepository.existsByRegion_IdAndName(8L, "Río Claro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Río Claro");
            communeRepository.save(commune);
        }

        //San Clemente 9
        if (!communeRepository.existsByRegion_IdAndName(8L, "San Clemente")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Clemente");
            communeRepository.save(commune);
        }

        //San Rafael 10
        if (!communeRepository.existsByRegion_IdAndName(8L, "San Rafael")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Rafael");
            communeRepository.save(commune);
        }

        //Cauquenes 11
        if (!communeRepository.existsByRegion_IdAndName(8L, "Cauquenes")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cauquenes");
            communeRepository.save(commune);
        }

        //Chanco 12
        if (!communeRepository.existsByRegion_IdAndName(8L, "Chanco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chanco");
            communeRepository.save(commune);
        }

        //Pelluhue 13
        if (!communeRepository.existsByRegion_IdAndName(8L, "Pelluhue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pelluhue");
            communeRepository.save(commune);
        }

        //Curicó 14
        if (!communeRepository.existsByRegion_IdAndName(8L, "Curicó")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curicó");
            communeRepository.save(commune);
        }

        //Hualañé 15
        if (!communeRepository.existsByRegion_IdAndName(8L, "Hualañé")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Hualañé");
            communeRepository.save(commune);
        }

        //Licantén 16
        if (!communeRepository.existsByRegion_IdAndName(8L, "Licantén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Licantén");
            communeRepository.save(commune);
        }

        //Molina 17
        if (!communeRepository.existsByRegion_IdAndName(8L, "Molina")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Molina");
            communeRepository.save(commune);
        }

        //Rauco 18
        if (!communeRepository.existsByRegion_IdAndName(8L, "Rauco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Rauco");
            communeRepository.save(commune);
        }

        //Romeral 19
        if (!communeRepository.existsByRegion_IdAndName(8L, "Romeral")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Romeral");
            communeRepository.save(commune);
        }

        //Sagrada Familia 20
        if (!communeRepository.existsByRegion_IdAndName(8L, "Sagrada Familia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Sagrada Familia");
            communeRepository.save(commune);
        }

        //Teno 21
        if (!communeRepository.existsByRegion_IdAndName(8L, "Teno")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Teno");
            communeRepository.save(commune);
        }

        //Vichuquén 22
        if (!communeRepository.existsByRegion_IdAndName(8L, "Vichuquén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Vichuquén");
            communeRepository.save(commune);
        }

        //Linares 23
        if (!communeRepository.existsByRegion_IdAndName(8L, "Linares")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Linares");
            communeRepository.save(commune);
        }

        //Colbún 24
        if (!communeRepository.existsByRegion_IdAndName(8L, "Colbún")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Colbún");
            communeRepository.save(commune);
        }

        //Longaví 25
        if (!communeRepository.existsByRegion_IdAndName(8L, "Longaví")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Longaví");
            communeRepository.save(commune);
        }

        //Parral 26
        if (!communeRepository.existsByRegion_IdAndName(8L, "Parral")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Parral");
            communeRepository.save(commune);
        }

        //Retiro 27
        if (!communeRepository.existsByRegion_IdAndName(8L, "Retiro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Retiro");
            communeRepository.save(commune);
        }

        //San Javier 28
        if (!communeRepository.existsByRegion_IdAndName(8L, "San Javier")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Javier");
            communeRepository.save(commune);
        }

        //Villa Alegre 29
        if (!communeRepository.existsByRegion_IdAndName(8L, "Villa Alegre")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Villa Alegre");
            communeRepository.save(commune);
        }

        //Yerbas Buenas 30
        if (!communeRepository.existsByRegion_IdAndName(8L, "Yerbas Buenas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Yerbas Buenas");
            communeRepository.save(commune);
        }


    }
}
