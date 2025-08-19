package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Velocidad {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Velocidad() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(9L).orElse(null);

        if (measurementUnitTypeRepository.existsById(9L)) {

            //Metros por segundo
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de velocidad", "m/s")) {
                measurementUnit.setAbbrev("m/s");
                measurementUnit.setName("Metros por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilometros por hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de velocidad", "km/h")) {
                measurementUnit.setAbbrev("km/h");
                measurementUnit.setName("Kilometros por hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Millas por hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de velocidad", "mph")) {
                measurementUnit.setAbbrev("mph");
                measurementUnit.setName("Millas por hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Nudos
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de velocidad", "kt")) {
                measurementUnit.setAbbrev("kt");
                measurementUnit.setName("Nudos");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Pies por segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de velocidad", "ft/s")) {
                measurementUnit.setAbbrev("ft/s");
                measurementUnit.setName("Pies por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }



        }

    }


}
