package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_VII {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_VII() {

        Region region = regionRepository.findById(7L).orElse(null);

        //Rancagua 1
        if (!communeRepository.existsByRegion_IdAndName(7L, "Rancagua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Rancagua");
            communeRepository.save(commune);
        }

        //Codegua 2
        if (!communeRepository.existsByRegion_IdAndName(7L, "Codegua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Codegua");
            communeRepository.save(commune);
        }

        //Coinco 3
        if (!communeRepository.existsByRegion_IdAndName(7L, "Coinco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coinco");
            communeRepository.save(commune);
        }

        //Coltauco 4
        if (!communeRepository.existsByRegion_IdAndName(7L, "Coltauco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coltauco");
            communeRepository.save(commune);
        }

        //Doñihue 5
        if (!communeRepository.existsByRegion_IdAndName(7L, "Doñihue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Doñihue");
            communeRepository.save(commune);
        }

        //Graneros 6
        if (!communeRepository.existsByRegion_IdAndName(7L, "Graneros")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Graneros");
            communeRepository.save(commune);
        }

        //Las Cabras 7
        if (!communeRepository.existsByRegion_IdAndName(7L, "Las Cabras")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Las Cabras");
            communeRepository.save(commune);
        }

        //Machalí 8
        if (!communeRepository.existsByRegion_IdAndName(7L, "Machalí")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Machalí");
            communeRepository.save(commune);
        }

        //Malloa 9
        if (!communeRepository.existsByRegion_IdAndName(7L, "Malloa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Malloa");
            communeRepository.save(commune);
        }

        //Mostazal 10
        if (!communeRepository.existsByRegion_IdAndName(7L, "Mostazal")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Mostazal");
            communeRepository.save(commune);
        }

        //Olivar 11
        if (!communeRepository.existsByRegion_IdAndName(7L, "Olivar")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Olivar");
            communeRepository.save(commune);
        }

        //Peumo 12
        if (!communeRepository.existsByRegion_IdAndName(7L, "Peumo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Peumo");
            communeRepository.save(commune);
        }

        //Pichidegua 13
        if (!communeRepository.existsByRegion_IdAndName(7L, "Pichidegua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pichidegua");
            communeRepository.save(commune);
        }

        //Quinta de Tilcoco 14
        if (!communeRepository.existsByRegion_IdAndName(7L, "Quinta de Tilcoco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quinta de Tilcoco");
            communeRepository.save(commune);
        }

        //Rengo 15
        if (!communeRepository.existsByRegion_IdAndName(7L, "Rengo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Rengo");
            communeRepository.save(commune);
        }

        //Requínoa 16
        if (!communeRepository.existsByRegion_IdAndName(7L, "Requínoa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Requínoa");
            communeRepository.save(commune);
        }

        //San Vicente 17
        if (!communeRepository.existsByRegion_IdAndName(7L, "San Vicente")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Vicente");
            communeRepository.save(commune);
        }

        //Pichilemu 18
        if (!communeRepository.existsByRegion_IdAndName(7L, "Pichilemu")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pichilemu");
            communeRepository.save(commune);
        }

        //La Estrella 19
        if (!communeRepository.existsByRegion_IdAndName(7L, "La Estrella")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Estrella");
            communeRepository.save(commune);
        }

        //Litueche 20
        if (!communeRepository.existsByRegion_IdAndName(7L, "Litueche")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Litueche");
            communeRepository.save(commune);
        }

        //Marchihue 21
        if (!communeRepository.existsByRegion_IdAndName(7L, "Marchihue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Marchihue");
            communeRepository.save(commune);
        }

        //Navidad 22
        if (!communeRepository.existsByRegion_IdAndName(7L, "Navidad")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Navidad");
            communeRepository.save(commune);
        }

        //Paredones 23
        if (!communeRepository.existsByRegion_IdAndName(7L, "Paredones")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Paredones");
            communeRepository.save(commune);
        }

        //San Fernando 24
        if (!communeRepository.existsByRegion_IdAndName(7L, "San Fernando")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Fernando");
            communeRepository.save(commune);
        }

        //Chépica 25
        if (!communeRepository.existsByRegion_IdAndName(7L, "Chépica")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chépica");
            communeRepository.save(commune);
        }

        //Chimbarongo 26
        if (!communeRepository.existsByRegion_IdAndName(7L, "Chimbarongo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chimbarongo");
            communeRepository.save(commune);
        }

        //Lolol 27
        if (!communeRepository.existsByRegion_IdAndName(7L, "Lolol")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lolol");
            communeRepository.save(commune);
        }

        //Nancagua 28
        if (!communeRepository.existsByRegion_IdAndName(7L, "Nancagua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Nancagua");
            communeRepository.save(commune);
        }

        //Palmilla 29
        if (!communeRepository.existsByRegion_IdAndName(7L, "Palmilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Palmilla");
            communeRepository.save(commune);
        }

        //Peralillo 30
        if (!communeRepository.existsByRegion_IdAndName(7L, "Peralillo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Peralillo");
            communeRepository.save(commune);
        }

        //Placilla 31
        if (!communeRepository.existsByRegion_IdAndName(7L, "Placilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Placilla");
            communeRepository.save(commune);
        }

        //Pumanque 32
        if (!communeRepository.existsByRegion_IdAndName(7L, "Pumanque")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pumanque");
            communeRepository.save(commune);
        }

        //Santa Cruz 33
        if (!communeRepository.existsByRegion_IdAndName(7L, "Santa Cruz")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santa Cruz");
            communeRepository.save(commune);
        }
    }

    }
