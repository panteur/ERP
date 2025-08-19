package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_Region;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadRegion {

    @Autowired
    private RegionRepository regionRepository;

    public void loadRegion() {

        //Región de Arica y Parinacota
        Region region = new Region();
        if (!regionRepository.existsByName("Región de Arica y Parinacota")) {
            region.setName("Región de Arica y Parinacota");
            region.setOrdinal("I");
            regionRepository.save(region);
        }

        //Región de Tarapacá
        region = new Region();
        if (!regionRepository.existsByName("Región de Tarapacá")) {
            region.setName("Región de Tarapacá");
            region.setOrdinal("II");
            regionRepository.save(region);
        }

        //Región de Antofagasta
        region = new Region();
        if (!regionRepository.existsByName("Región de Antofagasta")) {
            region.setName("Región de Antofagasta");
            region.setOrdinal("III");
            regionRepository.save(region);
        }

        //Región de Atacama
        region = new Region();
        if (!regionRepository.existsByName("Región de Atacama")) {
            region.setName("Región de Atacama");
            region.setOrdinal("IV");
            regionRepository.save(region);
        }

        //Región de Coquimbo
        region = new Region();
        if (!regionRepository.existsByName("Región de Coquimbo")) {
            region.setName("Región de Coquimbo");
            region.setOrdinal("V");
            regionRepository.save(region);
        }

        //Región de Valparaíso
        region = new Region();
        if (!regionRepository.existsByName("Región de Valparaíso")) {
            region.setName("Región de Valparaíso");
            region.setOrdinal("VI");
            regionRepository.save(region);
        }


        //Región del Libertador General Bernardo O'Higgins
        region = new Region();
        if (!regionRepository.existsByName("Región del Libertador General Bernardo O'Higgins")) {
            region.setName("Región del Libertador General Bernardo O'Higgins");
            region.setOrdinal("VII");
            regionRepository.save(region);
        }

        //Región del Maule
        region = new Region();
        if (!regionRepository.existsByName("Región del Maule")) {
            region.setName("Región del Maule");
            region.setOrdinal("VIII");
            regionRepository.save(region);
        }

        //Región del Ñuble
        region = new Region();
        if (!regionRepository.existsByName("Región del Ñuble")) {
            region.setName("Región del Ñuble");
            region.setOrdinal("IX");
            regionRepository.save(region);
        }

        //Región del Biobío
        region = new Region();
        if (!regionRepository.existsByName("Región del Biobío")) {
            region.setName("Región del Biobío");
            region.setOrdinal("X");
            regionRepository.save(region);
        }

        //Región de La Araucanía
        region = new Region();
        if (!regionRepository.existsByName("Región de La Araucanía")) {
            region.setName("Región de La Araucanía");
            region.setOrdinal("XI");
            regionRepository.save(region);
        }

        //Región de Los Ríos
        region = new Region();
        if (!regionRepository.existsByName("Región de Los Ríos")) {
            region.setName("Región de Los Ríos");
            region.setOrdinal("XII");
            regionRepository.save(region);
        }

        //Región de Los Lagos
        region = new Region();
        if (!regionRepository.existsByName("Región de Los Lagos")) {
            region.setName("Región de Los Lagos");
            region.setOrdinal("XIII");
            regionRepository.save(region);
        }

        //Región de Aysén del General Carlos Ibáñez del Campo
        region = new Region();
        if (!regionRepository.existsByName("Región de Aysén del General Carlos Ibáñez del Campo")) {
            region.setName("Región de Aysén del General Carlos Ibáñez del Campo");
            region.setOrdinal("XIV");
            regionRepository.save(region);
        }

        //Región de Magallanes y de la Antártica Chilena
        region = new Region();
        if (!regionRepository.existsByName("Región de Magallanes y de la Antártica Chilena")) {
            region.setName("Región de Magallanes y de la Antártica Chilena");
            region.setOrdinal("XV");
            regionRepository.save(region);
        }

        //Región Metropolitana de Santiago
        region = new Region();
        if (!regionRepository.existsByName("Región Metropolitana de Santiago")) {
            region.setName("Región Metropolitana de Santiago");
            region.setOrdinal("XVI");
            regionRepository.save(region);
        }



    }

}
