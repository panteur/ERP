package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Presion {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Presion() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(10L).orElse(null);

        if (measurementUnitTypeRepository.existsById(10L)) {

            //Pascal
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de presion", "Pa")) {
                measurementUnit.setAbbrev("Pa");
                measurementUnit.setName("Pascal");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Bar
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de presion", "bar")) {
                measurementUnit.setAbbrev("bar");
                measurementUnit.setName("Bar");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Atmosfera
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de presion", "atm")) {
                measurementUnit.setAbbrev("atm");
                measurementUnit.setName("Atmosfera");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Torr
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de presion", "torr")) {
                measurementUnit.setAbbrev("Torr");
                measurementUnit.setName("Torr");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //psi
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de presion", "psi")) {
                measurementUnit.setAbbrev("psi");
                measurementUnit.setName("Psi");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

        }

    }

}
