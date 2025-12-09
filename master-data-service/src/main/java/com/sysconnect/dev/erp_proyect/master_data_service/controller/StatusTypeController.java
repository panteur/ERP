package com.sysconnect.dev.erp_proyect.master_data_service.controller;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;
import com.sysconnect.dev.erp_proyect.master_data_service.service.StatusTypeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/status_type")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusTypeController {

    private static final String CIRCUIT_BREAKER_NAME = "status-type";

    @Autowired
    private StatusTypeService statusTypeService;


    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusType")
    public ResponseEntity<StatusType> getStatusTypeById(@PathVariable("id") Long id) {
        StatusType statusTypeBD = statusTypeService.findById(id);
        if (statusTypeBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeBD);
    }


    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusTypeList")
    public ResponseEntity<List<StatusType>> getAllStatusType() {
        List<StatusType> statusTypeList = statusTypeService.findAll();
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @GetMapping("/name/{name}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusTypeList")
    public ResponseEntity<List<StatusType>> getByNameContains(@PathVariable("name") String name) {
        List<StatusType> statusTypeList = statusTypeService.findByNameContainsIgnoreCase(name);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }



    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusTypeList")
    public ResponseEntity<List<StatusType>> getStatusTypeByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<StatusType> statusTypeList = statusTypeService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusTypeList")
    public ResponseEntity<List<StatusType>> getStatusTypeByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<StatusType> statusTypeList = statusTypeService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusType")
    public ResponseEntity<StatusType> createStatusType(@RequestBody StatusType statusType){
        StatusType statusTypeDB = statusTypeService.createStatusType(statusType);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(statusTypeDB);
    }

    @PutMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusType")
    public ResponseEntity<StatusType> updateStatusType(@PathVariable("id") Long id, @RequestBody StatusType statusType) {
        statusType.setId(id);
        StatusType statusTypeDB = statusTypeService.updateStatusType(statusType);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeDB);
    }

    @DeleteMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusType")
    public ResponseEntity<StatusType> deleteStatusType(@PathVariable("id") Long id) {
        StatusType statusTypeDB = statusTypeService.deleteStatusType(id);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeDB);
    }

    // --- Fallback Methods ---
    public ResponseEntity<List<StatusType>> fallbackStatusTypeList(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    public ResponseEntity<StatusType> fallbackStatusType(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
