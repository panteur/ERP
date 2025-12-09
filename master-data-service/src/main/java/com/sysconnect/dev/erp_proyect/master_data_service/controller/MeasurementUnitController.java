package com.sysconnect.dev.erp_proyect.master_data_service.controller;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnit;
import com.sysconnect.dev.erp_proyect.master_data_service.service.MeasurementUnitService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/measurement_unit")
@CrossOrigin(origins = "http://localhost:4200")
public class MeasurementUnitController {

    private static final String CIRCUIT_BREAKER_NAME = "measurement-unit";

    @Autowired
    private MeasurementUnitService measurementUnitService;


    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnit")
    public ResponseEntity<MeasurementUnit> getMeasurementUnitById(@PathVariable("id") Long id) {
        MeasurementUnit measurementUnitBD = measurementUnitService.findById(id);
        if (measurementUnitBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitBD);
    }


    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnitList")
    public ResponseEntity<List<MeasurementUnit>> getAllMeasurementUnit() {
        List<MeasurementUnit> measurementUnitList = measurementUnitService.findAll();
        if (measurementUnitList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitList);
    }


    @GetMapping("/name/{name}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnitList")
    public ResponseEntity<List<MeasurementUnit>> getByNameContains(@PathVariable("name") String name) {
        List<MeasurementUnit> measurementUnitList = measurementUnitService.findByNameContainsIgnoreCase(name);
        if (measurementUnitList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitList);
    }

    @GetMapping("/measurement_unit_type_id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnitList")
    public ResponseEntity<List<MeasurementUnit>> getByMeasurementUTypeId(@PathVariable("id") Long id) {
        List<MeasurementUnit> measurementUnitList = measurementUnitService.findByMeasurementUnitTypeId(id);
        if (measurementUnitList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitList);
    }


    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnitList")
    public ResponseEntity<List<MeasurementUnit>> getMeasurementUnitByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<MeasurementUnit> measurementUnitList = measurementUnitService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (measurementUnitList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnitList")
    public ResponseEntity<List<MeasurementUnit>> getMeasurementUnitByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<MeasurementUnit> measurementUnitList = measurementUnitService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (measurementUnitList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnit")
    public ResponseEntity<MeasurementUnit> createMeasurementUnit(@RequestBody MeasurementUnit measurementUnit) {
        MeasurementUnit measurementUnitDB = measurementUnitService.saveMeasurementUnit(measurementUnit);
        if (measurementUnitDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(measurementUnitDB);
    }

    @PutMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnit")
    public ResponseEntity<MeasurementUnit> updateMeasurementUnit(@PathVariable("id") Long id, @RequestBody MeasurementUnit measurementUnit) {
        measurementUnit.setId(id);
        MeasurementUnit measurementUnitDB = measurementUnitService.updateMeasurementUnit(measurementUnit);
        if (measurementUnitDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitDB);
    }

    @DeleteMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackMeasurementUnit")
    public ResponseEntity<MeasurementUnit> deleteMeasurementUnit(@PathVariable("id") Long id) {
        MeasurementUnit measurementUnitDB = measurementUnitService.deleteMeasurementUnit(id);
        if (measurementUnitDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitDB);
    }

    // --- Fallback Methods ---
    public ResponseEntity<List<MeasurementUnit>> fallbackMeasurementUnitList(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    public ResponseEntity<MeasurementUnit> fallbackMeasurementUnit(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
