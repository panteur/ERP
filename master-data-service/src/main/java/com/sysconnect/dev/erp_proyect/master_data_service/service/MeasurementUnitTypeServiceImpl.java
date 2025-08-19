package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.MeasurementUnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeasurementUnitTypeServiceImpl implements MeasurementUnitTypeService{

    @Autowired
    private MeasurementUnitTypeRepository measurementUnitTypeRepository;

    @Override
    public MeasurementUnitType findById(Long id) {
        return measurementUnitTypeRepository.findById(id).orElse(null);
    }

    @Override
    public long countById(Long id) {
        return measurementUnitTypeRepository.countById(id);
    }

    @Override
    public List<MeasurementUnitType> findAll() {
        return measurementUnitTypeRepository.findAll();
    }

    @Override
    public List<MeasurementUnitType> findByNameContains(String name) {
        return measurementUnitTypeRepository.findByNameContains(name);
    }

    @Override
    public List<MeasurementUnitType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return measurementUnitTypeRepository.findByCreateAtBetween(createAtStart,createAtEnd);
    }

    @Override
    public List<MeasurementUnitType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return measurementUnitTypeRepository.findByUpdateAtBetween(updateAtStart,updateAtEnd);
    }

    @Override
    public MeasurementUnitType createMeasurementUnitType(MeasurementUnitType measurementUnitType) {
        return measurementUnitTypeRepository.save(measurementUnitType);
    }

    @Override
    public MeasurementUnitType updateMeasurementUnitType(MeasurementUnitType measurementUnitType) {
        MeasurementUnitType measurementUnitTypeDB = measurementUnitTypeRepository.findById(measurementUnitType.getId()).orElse(null);
        if (measurementUnitTypeDB == null) return null;
        measurementUnitTypeDB.setName(measurementUnitType.getName());
        measurementUnitTypeDB.setDescription(measurementUnitType.getDescription());
        return measurementUnitTypeRepository.save(measurementUnitType);
    }

    @Override
    public MeasurementUnitType deleteMeasurementUnitType(Long id) {
        MeasurementUnitType measurementUnitTypeDB = measurementUnitTypeRepository.findById(id).orElse(null);
        if (measurementUnitTypeDB == null) return null;
        measurementUnitTypeRepository.delete(measurementUnitTypeDB);
        return measurementUnitTypeDB;
    }
}
