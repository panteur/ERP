package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_X {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_X() {

        Region region = regionRepository.findById(10L).orElse(null);

        //Concepción 1
        if (!communeRepository.existsByRegion_IdAndName(10L, "Concepción")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Concepción");
            communeRepository.save(commune);
        }

        //Coronel 2
        if (!communeRepository.existsByRegion_IdAndName(10L, "Coronel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Coronel");
            communeRepository.save(commune);
        }

        //Chiguayante 3
        if (!communeRepository.existsByRegion_IdAndName(10L, "Chiguayante")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Chiguayante");
            communeRepository.save(commune);
        }

        //Florida 4
        if (!communeRepository.existsByRegion_IdAndName(10L, "Florida")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Florida");
            communeRepository.save(commune);
        }

        //Hualqui 5
        if (!communeRepository.existsByRegion_IdAndName(10L, "Hualqui")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Hualqui");
            communeRepository.save(commune);
        }

        //Lota 6
        if (!communeRepository.existsByRegion_IdAndName(10L, "Lota")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lota");
            communeRepository.save(commune);
        }

        //Penco 7
        if (!communeRepository.existsByRegion_IdAndName(10L, "Penco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Penco");
            communeRepository.save(commune);
        }

        //San Pedro de la Paz 8
        if (!communeRepository.existsByRegion_IdAndName(10L, "San Pedro de la Paz")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Pedro de la Paz");
            communeRepository.save(commune);
        }

        //Santa Juana 9
        if (!communeRepository.existsByRegion_IdAndName(10L, "Santa Juana")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santa Juana");
            communeRepository.save(commune);
        }

        //Talcahuano 10
        if (!communeRepository.existsByRegion_IdAndName(10L, "Talcahuano")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Talcahuano");
            communeRepository.save(commune);
        }

        //Tomé 11
        if (!communeRepository.existsByRegion_IdAndName(10L, "Tomé")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tomé");
            communeRepository.save(commune);
        }

        //Hualpén 12
        if (!communeRepository.existsByRegion_IdAndName(10L, "Hualpén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Hualpén");
            communeRepository.save(commune);
        }

        //Lebu 13
        if (!communeRepository.existsByRegion_IdAndName(10L, "Lebu")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lebu");
            communeRepository.save(commune);
        }

        //Arauco 14
        if (!communeRepository.existsByRegion_IdAndName(10L, "Arauco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Arauco");
            communeRepository.save(commune);
        }

        //Cañete 15
        if (!communeRepository.existsByRegion_IdAndName(10L, "Cañete")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cañete");
            communeRepository.save(commune);
        }

        //Contulmo 16
        if (!communeRepository.existsByRegion_IdAndName(10L, "Contulmo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Contulmo");
            communeRepository.save(commune);
        }

        //Curanilahue 17
        if (!communeRepository.existsByRegion_IdAndName(10L, "Curanilahue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curanilahue");
            communeRepository.save(commune);
        }

        //Los Álamos 18
        if (!communeRepository.existsByRegion_IdAndName(10L, "Los Álamos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Álamos");
            communeRepository.save(commune);
        }

        //Tirúa 19
        if (!communeRepository.existsByRegion_IdAndName(10L, "Tirúa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tirúa");
            communeRepository.save(commune);
        }

        //Los Ángeles 20
        if (!communeRepository.existsByRegion_IdAndName(10L, "Los Ángeles")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Ángeles");
            communeRepository.save(commune);
        }

        //Antuco 21
        if (!communeRepository.existsByRegion_IdAndName(10L, "Antuco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Antuco");
            communeRepository.save(commune);
        }

        //Cabrero 22
        if (!communeRepository.existsByRegion_IdAndName(10L, "Cabrero")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cabrero");
            communeRepository.save(commune);
        }

        //Laja 23
        if (!communeRepository.existsByRegion_IdAndName(10L, "Laja")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Laja");
            communeRepository.save(commune);
        }

        //Mulchén 24
        if (!communeRepository.existsByRegion_IdAndName(10L, "Mulchén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Mulchén");
            communeRepository.save(commune);
        }

        //Nacimiento 25
        if (!communeRepository.existsByRegion_IdAndName(10L, "Nacimiento")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Nacimiento");
            communeRepository.save(commune);
        }

        //Negrete 26
        if (!communeRepository.existsByRegion_IdAndName(10L, "Negrete")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Negrete");
            communeRepository.save(commune);
        }

        //Quilaco 27
        if (!communeRepository.existsByRegion_IdAndName(10L, "Quilaco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quilaco");
            communeRepository.save(commune);
        }

        //Quilleco 28
        if (!communeRepository.existsByRegion_IdAndName(10L, "Quilleco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quilleco");
            communeRepository.save(commune);
        }

        //San Rosendo 29
        if (!communeRepository.existsByRegion_IdAndName(10L, "San Rosendo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Rosendo");
            communeRepository.save(commune);
        }

        //Santa Bárbara 30
        if (!communeRepository.existsByRegion_IdAndName(10L, "Santa Bárbara")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santa Bárbara");
            communeRepository.save(commune);
        }

        //Tucapel 31
        if (!communeRepository.existsByRegion_IdAndName(10L, "Tucapel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tucapel");
            communeRepository.save(commune);
        }

        //Yumbel 32
        if (!communeRepository.existsByRegion_IdAndName(10L, "Yumbel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Yumbel");
            communeRepository.save(commune);
        }

        //Alto Biobío 33
        if (!communeRepository.existsByRegion_IdAndName(10L, "Alto Biobío")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Alto Biobío");
            communeRepository.save(commune);
        }

    }

}
