package com.sysconnect.dev.erp_proyect.master_data_service.controller;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.MeasurementUnitType;
import com.sysconnect.dev.erp_proyect.master_data_service.service.MeasurementUnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/measurement_unit_type")
@CrossOrigin(origins = "http://localhost:4200")
public class MeasurementUnitTypeController {

    @Autowired
    private MeasurementUnitTypeService measurementUnitTypeService;


    @GetMapping("/id/{id}")
    public ResponseEntity<MeasurementUnitType> getMeasurementUnitTypeById(@PathVariable("id") Long id) {
        MeasurementUnitType measurementUnitTypeBD = measurementUnitTypeService.findById(id);
        if (measurementUnitTypeBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitTypeBD);
    }


    @GetMapping("/list")
    public ResponseEntity<List<MeasurementUnitType>> getAllMeasurementUnitType() {
        List<MeasurementUnitType> measurementUnitTypeList = measurementUnitTypeService.findAll();
        if (measurementUnitTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitTypeList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<MeasurementUnitType>> getByNameContains(@PathVariable("name") String name) {
        List<MeasurementUnitType> measurementUnitTypeList = measurementUnitTypeService.findByNameContains(name);
        if (measurementUnitTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitTypeList);
    }



    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    public ResponseEntity<List<MeasurementUnitType>> getMeasurementUnitTypeByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<MeasurementUnitType> measurementUnitTypeList = measurementUnitTypeService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (measurementUnitTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitTypeList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    public ResponseEntity<List<MeasurementUnitType>> getMeasurementUnitTypeByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<MeasurementUnitType> measurementUnitTypeList = measurementUnitTypeService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (measurementUnitTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(measurementUnitTypeList);
    }

    @PostMapping
    public ResponseEntity<MeasurementUnitType> createMeasurementUnitType(@RequestBody MeasurementUnitType measurementUnitType){
        MeasurementUnitType measurementUnitTypeDB = measurementUnitTypeService.createMeasurementUnitType(measurementUnitType);
        if (measurementUnitTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(measurementUnitTypeDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MeasurementUnitType> updateMeasurementUnitType(@PathVariable("id") Long id, @RequestBody MeasurementUnitType measurementUnitType) {
        measurementUnitType.setId(id);
        MeasurementUnitType measurementUnitTypeDB = measurementUnitTypeService.updateMeasurementUnitType(measurementUnitType);
        if (measurementUnitTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitTypeDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MeasurementUnitType> deleteMeasurementUnitType(@PathVariable("id") Long id) {
        MeasurementUnitType measurementUnitTypeDB = measurementUnitTypeService.deleteMeasurementUnitType(id);
        if (measurementUnitTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(measurementUnitTypeDB);
    }

}
