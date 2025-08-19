package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeasurementUnitServiceImpl implements MeasurementUnitService{

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Override
    public MeasurementUnit findById(Long id) {
        return measurementUnitRepository.findById(id).orElse(null);
    }

    @Override
    public Long countMeasurementUnit(Long id) {
        return measurementUnitRepository.countById(id);
    }

    @Override
    public List<MeasurementUnit> findAll() {
        return measurementUnitRepository.findAll();
    }

    @Override
    public List<MeasurementUnit> findByMeasurementUnitTypeId(Long id) {
        return measurementUnitRepository.findByMeasurementUnitType_Id(id);
    }


    @Override
    public List<MeasurementUnit> findByNameContainsIgnoreCase(String name) {
        return measurementUnitRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<MeasurementUnit> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return measurementUnitRepository.findByCreateAtBetween(createAtStart,createAtEnd);
    }

    @Override
    public List<MeasurementUnit> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return measurementUnitRepository.findByUpdateAtBetween(updateAtStart,updateAtEnd);
    }

    @Override
    public MeasurementUnit saveMeasurementUnit(MeasurementUnit measurementUnit) {
        return measurementUnitRepository.save(measurementUnit);
    }

    @Override
    public MeasurementUnit updateMeasurementUnit(MeasurementUnit measurementUnit) {
        MeasurementUnit measurementUnitDB = measurementUnitRepository.findById(measurementUnit.getId()).orElse(null);
        if (measurementUnitDB == null) return null;
        measurementUnitDB.setMeasurementUnitType(measurementUnit.getMeasurementUnitType());
        measurementUnitDB.setAbbrev(measurementUnit.getAbbrev());
        measurementUnitDB.setName(measurementUnit.getName());
        return measurementUnitRepository.save(measurementUnitDB);
    }

    @Override
    public MeasurementUnit deleteMeasurementUnit(Long id) {
        MeasurementUnit measurementUnitDB = measurementUnitRepository.findById(id).orElse(null);
        if (measurementUnitDB == null) return null;
        measurementUnitRepository.delete(measurementUnitDB);
        return measurementUnitDB;
    }
}
