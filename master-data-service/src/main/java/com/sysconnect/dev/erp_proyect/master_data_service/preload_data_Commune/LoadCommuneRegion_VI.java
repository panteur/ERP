package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_VI {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_VI() {

        Region region = regionRepository.findById(6L).orElse(null);

        //Valparaíso 1
        if (!communeRepository.existsByRegion_IdAndName(6L, "Valparaíso")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Valparaíso");
            communeRepository.save(commune);
        }

        //Casablanca 2
        if (!communeRepository.existsByRegion_IdAndName(6L, "Casablanca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Casablanca");
            communeRepository.save(commune);
        }

        //Concón 3
        if (!communeRepository.existsByRegion_IdAndName(6L, "Concón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Concón");
            communeRepository.save(commune);
        }

        //Juan Fernández 4
        if (!communeRepository.existsByRegion_IdAndName(6L, "Juan Fernández")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Juan Fernández");
            communeRepository.save(commune);
        }

        //Puchuncaví 5
        if (!communeRepository.existsByRegion_IdAndName(6L, "Puchuncaví")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puchuncaví");
            communeRepository.save(commune);
        }

        //Quintero 6
        if (!communeRepository.existsByRegion_IdAndName(6L, "Quintero")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quintero");
            communeRepository.save(commune);
        }

        //Viña del Mar 7
        if (!communeRepository.existsByRegion_IdAndName(6L, "Viña del Mar")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Viña del Mar");
            communeRepository.save(commune);
        }

        //Isla de Pascua 8
        if (!communeRepository.existsByRegion_IdAndName(6L, "Isla de Pascua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Isla de Pascua");
            communeRepository.save(commune);
        }

        //Los Andes 9
        if (!communeRepository.existsByRegion_IdAndName(6L, "Los Andes")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Los Andes");
            communeRepository.save(commune);
        }

        //Calle Larga 10
        if (!communeRepository.existsByRegion_IdAndName(6L, "Calle Larga")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Calle Larga");
            communeRepository.save(commune);
        }

        //Rinconada 11
        if (!communeRepository.existsByRegion_IdAndName(6L, "Rinconada")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Rinconada");
            communeRepository.save(commune);
        }

        //San Esteban 12
        if (!communeRepository.existsByRegion_IdAndName(6L, "San Esteban")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Esteban");
            communeRepository.save(commune);
        }

        //La Ligua 13
        if (!communeRepository.existsByRegion_IdAndName(6L, "La Ligua")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Ligua");
            communeRepository.save(commune);
        }

        //Cabildo 14
        if (!communeRepository.existsByRegion_IdAndName(6L, "Cabildo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cabildo");
            communeRepository.save(commune);
        }

        //Papudo 15
        if (!communeRepository.existsByRegion_IdAndName(6L, "Papudo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Papudo");
            communeRepository.save(commune);
        }

        //Petorca 16
        if (!communeRepository.existsByRegion_IdAndName(6L, "Petorca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Petorca");
            communeRepository.save(commune);
        }

        //Zapallar 17
        if (!communeRepository.existsByRegion_IdAndName(6L, "Zapallar")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Zapallar");
            communeRepository.save(commune);
        }

        //Quillota 18
        if (!communeRepository.existsByRegion_IdAndName(6L, "Quillota")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quillota");
            communeRepository.save(commune);
        }

        //Calera 19
        if (!communeRepository.existsByRegion_IdAndName(6L, "Calera")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Calera");
            communeRepository.save(commune);
        }

        //Hijuelas 20
        if (!communeRepository.existsByRegion_IdAndName(6L, "Hijuelas")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Hijuelas");
            communeRepository.save(commune);
        }

        //La Cruz 21
        if (!communeRepository.existsByRegion_IdAndName(6L, "La Cruz")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Cruz");
            communeRepository.save(commune);
        }

        //Nogales 22
        if (!communeRepository.existsByRegion_IdAndName(6L, "Nogales")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Nogales");
            communeRepository.save(commune);
        }

        //San Antonio 23
        if (!communeRepository.existsByRegion_IdAndName(6L, "San Antonio")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Antonio");
            communeRepository.save(commune);
        }

        //Algarrobo 24
        if (!communeRepository.existsByRegion_IdAndName(6L, "Algarrobo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Algarrobo");
            communeRepository.save(commune);
        }

        //Cartagena 25
        if (!communeRepository.existsByRegion_IdAndName(6L, "Cartagena")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cartagena");
            communeRepository.save(commune);
        }

        //El Quisco 26
        if (!communeRepository.existsByRegion_IdAndName(6L, "El Quisco")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("El Quisco");
            communeRepository.save(commune);
        }

        //El Tabo 27
        if (!communeRepository.existsByRegion_IdAndName(6L, "El Tabo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("El Tabo");
            communeRepository.save(commune);
        }

        //Santo Domingo 28
        if (!communeRepository.existsByRegion_IdAndName(6L, "Santo Domingo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santo Domingo");
            communeRepository.save(commune);
        }

        //San Felipe 29
        if (!communeRepository.existsByRegion_IdAndName(6L, "San Felipe")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Felipe");
            communeRepository.save(commune);
        }

        //Catemu 30
        if (!communeRepository.existsByRegion_IdAndName(6L, "Catemu")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Catemu");
            communeRepository.save(commune);
        }

        //Llaillay 31
        if (!communeRepository.existsByRegion_IdAndName(6L, "Llaillay")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Llaillay");
            communeRepository.save(commune);
        }

        //Panquehue 32
        if (!communeRepository.existsByRegion_IdAndName(6L, "Panquehue")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Panquehue");
            communeRepository.save(commune);
        }

        //Putaendo 33
        if (!communeRepository.existsByRegion_IdAndName(6L, "Putaendo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Putaendo");
            communeRepository.save(commune);
        }

        //Santa María 34
        if (!communeRepository.existsByRegion_IdAndName(6L, "Santa María")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santa María");
            communeRepository.save(commune);
        }

        //Quilpué 35
        if (!communeRepository.existsByRegion_IdAndName(6L, "Quilpué")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quilpué");
            communeRepository.save(commune);
        }

        //Limache 36
        if (!communeRepository.existsByRegion_IdAndName(6L, "Limache")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Limache");
            communeRepository.save(commune);
        }

        //Olmué 37
        if (!communeRepository.existsByRegion_IdAndName(6L, "Olmué")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Olmué");
            communeRepository.save(commune);
        }

        //Villa Alemana 38
        if (!communeRepository.existsByRegion_IdAndName(6L, "Villa Alemana")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Villa Alemana");
            communeRepository.save(commune);
        }

    }
}
