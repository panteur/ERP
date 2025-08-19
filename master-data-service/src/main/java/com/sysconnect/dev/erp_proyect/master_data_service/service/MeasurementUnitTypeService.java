package com.sysconnect.dev.erp_proyect.master_data_service.service;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;

import java.sql.Timestamp;
import java.util.List;

public interface MeasurementUnitTypeService {

    public MeasurementUnitType findById(Long id);
    public long countById(Long id);

    public List<MeasurementUnitType> findAll();
    public List<MeasurementUnitType> findByNameContains(String name);
    public List<MeasurementUnitType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);
    public List<MeasurementUnitType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    public MeasurementUnitType createMeasurementUnitType(MeasurementUnitType measurementUnitType);
    public MeasurementUnitType updateMeasurementUnitType(MeasurementUnitType measurementUnitType);
    public MeasurementUnitType deleteMeasurementUnitType(Long id);

}
