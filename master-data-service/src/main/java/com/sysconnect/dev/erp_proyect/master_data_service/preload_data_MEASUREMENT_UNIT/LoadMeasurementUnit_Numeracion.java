package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Numeracion {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Numeracion() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(15L).orElse(null);

        if (measurementUnitTypeRepository.existsById(15L)) {

            //unidades
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de numeracion", "u")) {
                measurementUnit.setAbbrev("unds");
                measurementUnit.setName("Unidades");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Decenas
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de numeracion", "d")) {
                measurementUnit.setAbbrev("dec");
                measurementUnit.setName("Decenas");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Centenas
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de numeracion", "c")) {
                measurementUnit.setAbbrev("cen");
                measurementUnit.setName("Centenas");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }




        }

    }

}
