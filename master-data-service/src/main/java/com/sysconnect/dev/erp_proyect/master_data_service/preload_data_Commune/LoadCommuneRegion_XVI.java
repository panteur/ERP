package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Commune;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.CommuneRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadCommuneRegion_XVI {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private RegionRepository regionRepository;


    public void LoadCommuneRegion_XVI() {

        Region region = regionRepository.findById(16L).orElse(null);

        //Santiago 1
        if (!communeRepository.existsByRegion_IdAndName(16L, "Santiago")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Santiago");
            communeRepository.save(commune);
        }

        //Cerrillos 2
        if (!communeRepository.existsByRegion_IdAndName(16L, "Cerrillos")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cerrillos");
            communeRepository.save(commune);
        }

        //Cerro Navia 3
        if (!communeRepository.existsByRegion_IdAndName(16L, "Cerro Navia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Cerro Navia");
            communeRepository.save(commune);
        }

        //Conchalí 4
        if (!communeRepository.existsByRegion_IdAndName(16L, "Conchalí")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Conchalí");
            communeRepository.save(commune);
        }

        //El Bosque 5
        if (!communeRepository.existsByRegion_IdAndName(16L, "El Bosque")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("El Bosque");
            communeRepository.save(commune);
        }

        //Estación Central 6
        if (!communeRepository.existsByRegion_IdAndName(16L, "Estación Central")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Estación Central");
            communeRepository.save(commune);
        }

        //Huechuraba 7
        if (!communeRepository.existsByRegion_IdAndName(16L, "Huechuraba")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Huechuraba");
            communeRepository.save(commune);
        }

        //Independencia 8
        if (!communeRepository.existsByRegion_IdAndName(16L, "Independencia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Independencia");
            communeRepository.save(commune);
        }

        //La Cisterna 9
        if (!communeRepository.existsByRegion_IdAndName(16L, "La Cisterna")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Cisterna");
            communeRepository.save(commune);
        }

        //La Florida 10
        if (!communeRepository.existsByRegion_IdAndName(16L, "La Florida")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Florida");
            communeRepository.save(commune);
        }

        //La Granja 11
        if (!communeRepository.existsByRegion_IdAndName(16L, "La Granja")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Granja");
            communeRepository.save(commune);
        }

        //La Pintana 12
        if (!communeRepository.existsByRegion_IdAndName(16L, "La Pintana")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Pintana");
            communeRepository.save(commune);
        }

        //La Reina 13
        if (!communeRepository.existsByRegion_IdAndName(16L, "La Reina")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("La Reina");
            communeRepository.save(commune);
        }

        //Las Condes 14
        if (!communeRepository.existsByRegion_IdAndName(16L, "Las Condes")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Las Condes");
            communeRepository.save(commune);
        }

        //Lo Barnechea 15
        if (!communeRepository.existsByRegion_IdAndName(16L, "Lo Barnechea")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lo Barnechea");
            communeRepository.save(commune);
        }

        //Lo Espejo 16
        if (!communeRepository.existsByRegion_IdAndName(16L, "Lo Espejo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lo Espejo");
            communeRepository.save(commune);
        }

        //Lo Prado 17
        if (!communeRepository.existsByRegion_IdAndName(16L, "Lo Prado")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lo Prado");
            communeRepository.save(commune);
        }

        //Macul 18
        if (!communeRepository.existsByRegion_IdAndName(16L, "Macul")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Macul");
            communeRepository.save(commune);
        }

        //Maipú 19
        if (!communeRepository.existsByRegion_IdAndName(16L, "Maipú")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Maipú");
            communeRepository.save(commune);
        }

        //Ñuñoa 20
        if (!communeRepository.existsByRegion_IdAndName(16L, "Ñuñoa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Ñuñoa");
            communeRepository.save(commune);
        }

        //Pedro Aguirre Cerda 21
        if (!communeRepository.existsByRegion_IdAndName(16L, "Pedro Aguirre Cerda")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pedro Aguirre Cerda");
            communeRepository.save(commune);
        }

        //Peñalolén 22
        if (!communeRepository.existsByRegion_IdAndName(16L, "Peñalolén")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Peñalolén");
            communeRepository.save(commune);
        }

        //Providencia 23
        if (!communeRepository.existsByRegion_IdAndName(16L, "Providencia")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Providencia");
            communeRepository.save(commune);
        }

        //Pudahuel 24
        if (!communeRepository.existsByRegion_IdAndName(16L, "Pudahuel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pudahuel");
            communeRepository.save(commune);
        }

        //Quilicura 25
        if (!communeRepository.existsByRegion_IdAndName(16L, "Quilicura")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quilicura");
            communeRepository.save(commune);
        }

        //Quinta Normal 26
        if (!communeRepository.existsByRegion_IdAndName(16L, "Quinta Normal")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Quinta Normal");
            communeRepository.save(commune);
        }

        //Recoleta 27
        if (!communeRepository.existsByRegion_IdAndName(16L, "Recoleta")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Recoleta");
            communeRepository.save(commune);
        }

        //Renca 28
        if (!communeRepository.existsByRegion_IdAndName(16L, "Renca")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Renca");
            communeRepository.save(commune);
        }

        //San Joaquín 29
        if (!communeRepository.existsByRegion_IdAndName(16L, "San Joaquín")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Joaquín");
            communeRepository.save(commune);
        }

        //San Miguel 30
        if (!communeRepository.existsByRegion_IdAndName(16L, "San Miguel")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Miguel");
            communeRepository.save(commune);
        }

        //San Ramón 31
        if (!communeRepository.existsByRegion_IdAndName(16L, "San Ramón")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Ramón");
            communeRepository.save(commune);
        }

        //Vitacura 32
        if (!communeRepository.existsByRegion_IdAndName(16L, "Vitacura")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Vitacura");
            communeRepository.save(commune);
        }

        //Puento Alto 33
        if (!communeRepository.existsByRegion_IdAndName(16L, "Puento Alto")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Puento Alto");
            communeRepository.save(commune);
        }

        //Pirque 34
        if (!communeRepository.existsByRegion_IdAndName(16L, "Pirque")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Pirque");
            communeRepository.save(commune);
        }

        //San José de Maipo 35
        if (!communeRepository.existsByRegion_IdAndName(16L, "San José de Maipo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San José de Maipo");
            communeRepository.save(commune);
        }

        //Colina 36
        if (!communeRepository.existsByRegion_IdAndName(16L, "Colina")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Colina");
            communeRepository.save(commune);
        }

        //Lampa 37
        if (!communeRepository.existsByRegion_IdAndName(16L, "Lampa")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Lampa");
            communeRepository.save(commune);
        }

        //Tiltil 38
        if (!communeRepository.existsByRegion_IdAndName(16L, "Tiltil")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Tiltil");
            communeRepository.save(commune);
        }

        //San Bernardo 39
        if (!communeRepository.existsByRegion_IdAndName(16L, "San Bernardo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Bernardo");
            communeRepository.save(commune);
        }

        //Buin 40
        if (!communeRepository.existsByRegion_IdAndName(16L, "Buin")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Buin");
            communeRepository.save(commune);
        }

        //Calera de Tango 41
        if (!communeRepository.existsByRegion_IdAndName(16L, "Calera de Tango")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Calera de Tango");
            communeRepository.save(commune);
        }

        //Paine 42
        if (!communeRepository.existsByRegion_IdAndName(16L, "Paine")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Paine");
            communeRepository.save(commune);
        }

        //Melipilla 43
        if (!communeRepository.existsByRegion_IdAndName(16L, "Melipilla")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Melipilla");
            communeRepository.save(commune);
        }

        //Alhué 44
        if (!communeRepository.existsByRegion_IdAndName(16L, "Alhué")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Alhué");
            communeRepository.save(commune);
        }

        //Curacaví 45
        if (!communeRepository.existsByRegion_IdAndName(16L, "Curacaví")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Curacaví");
            communeRepository.save(commune);
        }

        //María Pinto 46
        if (!communeRepository.existsByRegion_IdAndName(16L, "María Pinto")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("María Pinto");
            communeRepository.save(commune);
        }

        //San Pedro 47
        if (!communeRepository.existsByRegion_IdAndName(16L, "San Pedro")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("San Pedro");
            communeRepository.save(commune);
        }


        //Talagante 48
        if (!communeRepository.existsByRegion_IdAndName(16L, "Talagante")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Talagante");
            communeRepository.save(commune);
        }

        //El Monte 49
        if (!communeRepository.existsByRegion_IdAndName(16L, "El Monte")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("El Monte");
            communeRepository.save(commune);
        }

        //Isla de Maipo 50
        if (!communeRepository.existsByRegion_IdAndName(16L, "Isla de Maipo")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Isla de Maipo");
            communeRepository.save(commune);
        }

        //Padre Hurtado 51
        if (!communeRepository.existsByRegion_IdAndName(16L, "Padre Hurtado")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Padre Hurtado");
            communeRepository.save(commune);
        }

        //Peñaflor 52
        if (!communeRepository.existsByRegion_IdAndName(16L, "Peñaflor")) {
            Commune commune = new Commune();
            commune.setRegion(region);
            commune.setName("Peñaflor");
            communeRepository.save(commune);
        }

    }



}
