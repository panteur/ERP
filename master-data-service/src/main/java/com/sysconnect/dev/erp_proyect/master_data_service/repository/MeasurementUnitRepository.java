package com.sysconnect.dev.erp_proyect.master_data_service.repository;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {

    List<MeasurementUnit> findByNameContainsIgnoreCase(String name);

    List<MeasurementUnit> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);

    List<MeasurementUnit> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    long countById(Long id);

    List<MeasurementUnit> findByMeasurementUnitType_Id(Long id);

    @Query("select (count(m) > 0) from MeasurementUnit m where m.measurementUnitType.name = ?1 and m.abbrev = ?2")
    boolean existsByMeasurementUnitType_NameAndAbbrev(String name, String abbrev);

}