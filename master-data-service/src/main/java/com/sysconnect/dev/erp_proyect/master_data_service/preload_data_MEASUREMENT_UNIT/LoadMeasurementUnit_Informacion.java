package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Informacion {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Informacion() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(14L).orElse(null);

        if (measurementUnitTypeRepository.existsById(14L)) {


            //bite
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "b")) {
                measurementUnit.setAbbrev("b");
                measurementUnit.setName("Bite");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //byte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "B")) {
                measurementUnit.setAbbrev("B");
                measurementUnit.setName("Byte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //kilobyte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "KB")) {
                measurementUnit.setAbbrev("KB");
                measurementUnit.setName("Kilobyte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //megabyte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "MB")) {
                measurementUnit.setAbbrev("MB");
                measurementUnit.setName("Megabyte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //gigabyte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "GB")) {
                measurementUnit.setAbbrev("GB");
                measurementUnit.setName("Gigabyte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //terabyte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "TB")) {
                measurementUnit.setAbbrev("TB");
                measurementUnit.setName("Terabyte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //petabyte
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de informacion", "PB")) {
                measurementUnit.setAbbrev("PB");
                measurementUnit.setName("Petabyte");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }


        }
    }
}
