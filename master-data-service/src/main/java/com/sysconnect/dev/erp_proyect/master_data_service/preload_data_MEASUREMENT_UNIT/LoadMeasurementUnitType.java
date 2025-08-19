package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_MEASUREMENT_UNIT;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadMeasurementUnitType {

    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;

    public void loadMeasurementUnitType() {

        MeasurementUnitType measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de longitud")) {
            measurementUnitType.setName("Unidades de longitud");
            measurementUnitType.setDescription("Miden las distancia entre dos puntos");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de masa
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de masa")) {
            measurementUnitType.setName("Unidades de masa");
            measurementUnitType.setDescription("Miden la cantidad de materia que posee un cuerpo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de tiempo
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de tiempo")) {
            measurementUnitType.setName("Unidades de tiempo");
            measurementUnitType.setDescription("Miden la duracion de un evento");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de temperatura
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de temperatura")) {
            measurementUnitType.setName("Unidades de temperatura");
            measurementUnitType.setDescription("Miden el grado de calor o frío de un objeto o sistema");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de energía
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de energía")) {
            measurementUnitType.setName("Unidades de energía");
            measurementUnitType.setDescription("Miden la capacidad de un sistema para realizar trabajo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de fuerza
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de fuerza")) {
            measurementUnitType.setName("Unidades de fuerza");
            measurementUnitType.setDescription("Miden la capacidad de un cuerpo para realizar trabajo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de potencia
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de potencia")) {
            measurementUnitType.setName("Unidades de potencia");
            measurementUnitType.setDescription("Miden la cantidad de trabajo que se realiza en una unidad de tiempo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de superficie
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de superficie")) {
            measurementUnitType.setName("Unidades de superficie");
            measurementUnitType.setDescription("Miden la extensión de una superficie");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de velocidad
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de velocidad")) {
            measurementUnitType.setName("Unidades de velocidad");
            measurementUnitType.setDescription("Miden la rapidez con la que se desplaza un objeto");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de presión
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de presión")) {
            measurementUnitType.setName("Unidades de presión");
            measurementUnitType.setDescription("Miden la fuerza que ejerce un cuerpo sobre una superficie");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades eléctricas
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades eléctricas")) {
            measurementUnitType.setName("Unidades eléctricas");
            measurementUnitType.setDescription("Miden la cantidad de electricidad que circula por un conductor");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades luminosas
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades luminosas")) {
            measurementUnitType.setName("Unidades luminosas");
            measurementUnitType.setDescription("Miden la cantidad de luz que emite una fuente luminosa");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de volumen
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de volumen")) {
            measurementUnitType.setName("Unidades de volumen");
            measurementUnitType.setDescription("Miden la cantidad de espacio que ocupa un cuerpo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de informacion
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de informacion")) {
            measurementUnitType.setName("Unidades de informacion");
            measurementUnitType.setDescription("Miden la cantidad de informacion que puede ser almacenada en un dispositivo");
            measurementUnitTypeRepository.save(measurementUnitType);
        }

        //Unidades de Numeracion
        measurementUnitType = new MeasurementUnitType();
        if (!measurementUnitTypeRepository.existsByName("Unidades de Numeracion")) {
            measurementUnitType.setName("Unidades de Numeracion");
            measurementUnitType.setDescription("Representa la cantidad de objetos que se desea contar");
            measurementUnitTypeRepository.save(measurementUnitType);
        }



    }
}
