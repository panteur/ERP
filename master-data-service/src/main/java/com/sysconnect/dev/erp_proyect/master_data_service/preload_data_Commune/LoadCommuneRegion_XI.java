package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XI {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XI() {

        Region region = regionRepository.findById(11L).orElse(null);

        //Temuco 1
        if (!communeRepository.existsByRegion_IdAndName(11L, "Temuco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Temuco");
            communeRepository.save(commune);
        }

        //Carahue 2
        if (!communeRepository.existsByRegion_IdAndName(11L, "Carahue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Carahue");
            communeRepository.save(commune);
        }

        //Cunco 3
        if (!communeRepository.existsByRegion_IdAndName(11L, "Cunco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cunco");
            communeRepository.save(commune);
        }

        //Curarrehue 4
        if (!communeRepository.existsByRegion_IdAndName(11L, "Curarrehue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curarrehue");
            communeRepository.save(commune);
        }

        //Freire 5
        if (!communeRepository.existsByRegion_IdAndName(11L, "Freire")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Freire");
            communeRepository.save(commune);
        }

        //Galvarino 6
        if (!communeRepository.existsByRegion_IdAndName(11L, "Galvarino")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Galvarino");
            communeRepository.save(commune);
        }

        //Gorbea 7
        if (!communeRepository.existsByRegion_IdAndName(11L, "Gorbea")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Gorbea");
            communeRepository.save(commune);
        }

        //Lautaro 8
        if (!communeRepository.existsByRegion_IdAndName(11L, "Lautaro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lautaro");
            communeRepository.save(commune);
        }

        //Loncoche 9
        if (!communeRepository.existsByRegion_IdAndName(11L, "Loncoche")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Loncoche");
            communeRepository.save(commune);
        }

        //Melipeuco 10
        if (!communeRepository.existsByRegion_IdAndName(11L, "Melipeuco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Melipeuco");
            communeRepository.save(commune);
        }

        //Nueva Imperial 11
        if (!communeRepository.existsByRegion_IdAndName(11L, "Nueva Imperial")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Nueva Imperial");
            communeRepository.save(commune);
        }

        //Padre Las Casas 12
        if (!communeRepository.existsByRegion_IdAndName(11L, "Padre Las Casas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Padre Las Casas");
            communeRepository.save(commune);
        }

        //Perquenco 13
        if (!communeRepository.existsByRegion_IdAndName(11L, "Perquenco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Perquenco");
            communeRepository.save(commune);
        }

        //Pitrufquén 14
        if (!communeRepository.existsByRegion_IdAndName(11L, "Pitrufquén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pitrufquén");
            communeRepository.save(commune);
        }

        //Pucón 15
        if (!communeRepository.existsByRegion_IdAndName(11L, "Pucón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pucón");
            communeRepository.save(commune);
        }

        //Saavedra 16
        if (!communeRepository.existsByRegion_IdAndName(11L, "Saavedra")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Saavedra");
            communeRepository.save(commune);
        }

        //Teodoro Schmidt 17
        if (!communeRepository.existsByRegion_IdAndName(11L, "Teodoro Schmidt")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Teodoro Schmidt");
            communeRepository.save(commune);
        }

        //Toltén 18
        if (!communeRepository.existsByRegion_IdAndName(11L, "Toltén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Toltén");
            communeRepository.save(commune);
        }

        //Vilcún 19
        if (!communeRepository.existsByRegion_IdAndName(11L, "Vilcún")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Vilcún");
            communeRepository.save(commune);
        }

        //Villarrica 20
        if (!communeRepository.existsByRegion_IdAndName(11L, "Villarrica")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Villarrica");
            communeRepository.save(commune);
        }

        //Cholchol 21
        if (!communeRepository.existsByRegion_IdAndName(11L, "Cholchol")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cholchol");
            communeRepository.save(commune);
        }

        //Angol 22
        if (!communeRepository.existsByRegion_IdAndName(11L, "Angol")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Angol");
            communeRepository.save(commune);
        }

        //Collipulli 23
        if (!communeRepository.existsByRegion_IdAndName(11L, "Collipulli")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Collipulli");
            communeRepository.save(commune);
        }

        //Curacautín 24
        if (!communeRepository.existsByRegion_IdAndName(11L, "Curacautín")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curacautín");
            communeRepository.save(commune);
        }

        //Ercilla 25
        if (!communeRepository.existsByRegion_IdAndName(11L, "Ercilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ercilla");
            communeRepository.save(commune);
        }

        //Lonquimay 26
        if (!communeRepository.existsByRegion_IdAndName(11L, "Lonquimay")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lonquimay");
            communeRepository.save(commune);
        }

        //Los Sauces 27
        if (!communeRepository.existsByRegion_IdAndName(11L, "Los Sauces")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Sauces");
            communeRepository.save(commune);
        }

        //Lumaco 28
        if (!communeRepository.existsByRegion_IdAndName(11L, "Lumaco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lumaco");
            communeRepository.save(commune);
        }

        //Purén 29
        if (!communeRepository.existsByRegion_IdAndName(11L, "Purén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Purén");
            communeRepository.save(commune);
        }

        //Renaico 30
        if (!communeRepository.existsByRegion_IdAndName(11L, "Renaico")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Renaico");
            communeRepository.save(commune);
        }

        //Traiguén 31
        if (!communeRepository.existsByRegion_IdAndName(11L, "Traiguén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Traiguén");
            communeRepository.save(commune);
        }

        //Victoria 32
        if (!communeRepository.existsByRegion_IdAndName(11L, "Victoria")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Victoria");
            communeRepository.save(commune);
        }

    }

}
