package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Superficie {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Superficie() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(8L).orElse(null);

        if (measurementUnitTypeRepository.existsById(8L)) {

            //Metro cuadrado
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "m2")) {
                measurementUnit.setAbbrev("m2");
                measurementUnit.setName("Metro cuadrado");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Hectarea
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "ha")) {
                measurementUnit.setAbbrev("ha");
                measurementUnit.setName("Hectarea");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilometro cuadrado
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "km2")) {
                measurementUnit.setAbbrev("km2");
                measurementUnit.setName("Kilometro cuadrado");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Pulgada cuadrada
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "in2")) {
                measurementUnit.setAbbrev("in2");
                measurementUnit.setName("Pulgada cuadrada");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Pie cuadrado
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "ft2")) {
                measurementUnit.setAbbrev("ft2");
                measurementUnit.setName("Pie cuadrado");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Yarda cuadrada
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "yd2")) {
                measurementUnit.setAbbrev("yd2");
                measurementUnit.setName("Yarda cuadrada");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Milla cuadrada
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "mi2")) {
                measurementUnit.setAbbrev("mi2");
                measurementUnit.setName("Milla cuadrada");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Acre
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "ac")) {
                measurementUnit.setAbbrev("ac");
                measurementUnit.setName("Acre");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //centimetro cuadrado
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "cm2")) {
                measurementUnit.setAbbrev("cm2");
                measurementUnit.setName("Centimetro cuadrado");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Milimetro cuadrado
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de superficie", "mm2")) {
                measurementUnit.setAbbrev("mm2");
                measurementUnit.setName("Milimetro cuadrado");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

        }

    }

}
