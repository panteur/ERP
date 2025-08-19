package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnit_Potencia {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;


    public void loadMeasurementUnit_Potencia() {

        MeasurementUnitType mut = measurementUnitTypeRepository.findById(7L).orElse(null);

        if (measurementUnitTypeRepository.existsById(7L)) {

            //Watt
            MeasurementUnit measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "W")) {
                measurementUnit.setAbbrev("W");
                measurementUnit.setName("Watt");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilowatt
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "kW")) {
                measurementUnit.setAbbrev("kW");
                measurementUnit.setName("Kilowatt");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Caballo de fuerza
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "hp")) {
                measurementUnit.setAbbrev("hp");
                measurementUnit.setName("Caballo de fuerza");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Caballo de vapor
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "cv")) {
                measurementUnit.setAbbrev("cv");
                measurementUnit.setName("Caballo de vapor");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }


            //Calorias por segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "cal/s")) {
                measurementUnit.setAbbrev("cal/s");
                measurementUnit.setName("Calorias por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //BTU por hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "BTU/h")) {
                measurementUnit.setAbbrev("BTU/h");
                measurementUnit.setName("BTU por hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Pie-libra por segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "ft-lb/s")) {
                measurementUnit.setAbbrev("ft-lb/s");
                measurementUnit.setName("Pie-libra por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Ergio por segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "erg/s")) {
                measurementUnit.setAbbrev("erg/s");
                measurementUnit.setName("Ergio por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilocalorias por hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "kcal/h")) {
                measurementUnit.setAbbrev("kcal/h");
                measurementUnit.setName("Kilocalorias por hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilocalorias por segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "kcal/s")) {
                measurementUnit.setAbbrev("kcal/s");
                measurementUnit.setName("Kilocalorias por segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Kilovatio-hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "kWh")) {
                measurementUnit.setAbbrev("kWh");
                measurementUnit.setName("Kilovatio-hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Vatio-hora
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "Wh")) {
                measurementUnit.setAbbrev("Wh");
                measurementUnit.setName("Vatio-hora");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }

            //Vatio-segundo
            measurementUnit = new MeasurementUnit();
            if (!measurementUnitRepository.existsByMeasurementUnitType_NameAndAbbrev("Unidades de potencia", "Ws")) {
                measurementUnit.setAbbrev("Ws");
                measurementUnit.setName("Vatio-segundo");
                measurementUnit.setMeasurementUnitType(mut);
                measurementUnitRepository.save(measurementUnit);
            }



        }

    }


}
