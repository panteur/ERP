package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Electricas {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Electricas() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(11L).orElse(null);

        if (measurementUnitTypeRepository.existsById(11L)) {

            //Amperio
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "A")) {
                measurementUnit.setAbbrev("A");
                measurementUnit.setName("Amperio");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Voltio
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "V")) {
                measurementUnit.setAbbrev("V");
                measurementUnit.setName("Voltio");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Ohm
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "Ω")) {
                measurementUnit.setAbbrev("Ω");
                measurementUnit.setName("Ohm");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Watt
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "W")) {
                measurementUnit.setAbbrev("W");
                measurementUnit.setName("Watt");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Coulomb
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "C")) {
                measurementUnit.setAbbrev("C");
                measurementUnit.setName("Coulomb");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Farad
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "F")) {
                measurementUnit.setAbbrev("F");
                measurementUnit.setName("Farad");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Henry
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "H")) {
                measurementUnit.setAbbrev("H");
                measurementUnit.setName("Henry");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Siemens
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "S")) {
                measurementUnit.setAbbrev("S");
                measurementUnit.setName("Siemens");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Weber
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "Wb")) {
                measurementUnit.setAbbrev("Wb");
                measurementUnit.setName("Weber");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Tesla
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "T")) {
                measurementUnit.setAbbrev("T");
                measurementUnit.setName("Tesla");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Gauss
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "G")) {
                measurementUnit.setAbbrev("G");
                measurementUnit.setName("Gauss");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Joule
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de electricidad", "J")) {
                measurementUnit.setAbbrev("J");
                measurementUnit.setName("Joule");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }



        }

    }


}
