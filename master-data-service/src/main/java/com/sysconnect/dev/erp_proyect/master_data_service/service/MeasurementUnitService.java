package com.sysconnect.dev.erp_proyect.master_data_service.service;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;

import java.sql.Timestamp;
import java.util.List;

public interface MeasurementUnitService {

    public MeasurementUnit findById(Long id);
    public Long countMeasurementUnit(Long id);

    public List<MeasurementUnit> findAll();
    public List<MeasurementUnit> findByMeasurementUnitTypeId(Long id);
    public List<MeasurementUnit> findByNameContainsIgnoreCase(String name);
    public List<MeasurementUnit> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);
    public List<MeasurementUnit> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    public MeasurementUnit saveMeasurementUnit(MeasurementUnit measurementUnit);
    public MeasurementUnit updateMeasurementUnit(MeasurementUnit measurementUnit);
    public MeasurementUnit deleteMeasurementUnit(Long id);

}
