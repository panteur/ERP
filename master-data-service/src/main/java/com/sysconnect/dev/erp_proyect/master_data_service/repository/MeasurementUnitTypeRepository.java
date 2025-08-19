package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MeasurementUnitTypeRepository extends JpaRepository<MeasurementUnitType, Long> {
    List<MeasurementUnitType> findByNameContains(String name);

    List<MeasurementUnitType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<MeasurementUnitType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);

    boolean existsByName(String name);


    @Override
    boolean existsById(Long aLong);
}