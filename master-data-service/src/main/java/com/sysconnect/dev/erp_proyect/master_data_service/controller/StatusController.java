package com.sysconnect.dev.erp_proyect.master_data_service.controller;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.service.StatusService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/status/")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    private static final String CIRCUIT_BREAKER_NAME = "status";

    @Autowired
    private StatusService statusService;


    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatus")
    public ResponseEntity<Status> getStatusById(@PathVariable("id") Long id) {
        Status statusBD = statusService.findById(id);
        if (statusBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusBD);
    }

    @GetMapping("/codint/{codint}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatus")
    public ResponseEntity<Status> getStatusByCodint(@PathVariable("codint") String codint) {
        Status statusBD = statusService.findByCodint(codint);
        if (statusBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusBD);
    }


    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusList")
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statusList = statusService.findAll();
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/status_type_id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusList")
    public ResponseEntity<List<Status>> getByStatusTypeId(@PathVariable("id") Long id) {
        List<Status> statusList = statusService.findByStatusType_Id(id);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/name/{name}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusList")
    public ResponseEntity<List<Status>> getByNameContains(@PathVariable("name") String name) {
        List<Status> statusList = statusService.findByNameIgnoreCase(name);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusList")
    public ResponseEntity<List<Status>> getStatusByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<Status> statusList = statusService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatusList")
    public ResponseEntity<List<Status>> getStatusByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<Status> statusList = statusService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatus")
    public ResponseEntity<Status> createStatus(@RequestBody Status status){
        Status statusDB = statusService.createStatusService(status);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(statusDB);
    }

    @PutMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatus")
    public ResponseEntity<Status> updateStatus(@PathVariable("id") Long id, @RequestBody Status status) {
        status.setId(id);
        Status statusDB = statusService.updateStatus(status);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusDB);
    }

    @DeleteMapping(value = "/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackStatus")
    public ResponseEntity<Status> deleteStatus(@PathVariable("id") Long id) {
        Status statusDB = statusService.deleteStatus(id);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusDB);
    }

    // --- Fallback Methods ---

    /**
     * Fallback method for endpoints returning a list of Status.
     * Returns a 503 Service Unavailable with an empty list.
     * @param t The throwable that caused the circuit breaker to open.
     * @return A ResponseEntity with HTTP status 503.
     */
    public ResponseEntity<List<Status>> fallbackStatusList(Throwable t) {
        // You can add logging here to record the error
        // log.error("Circuit breaker for status list is open. Fallback executed.", t);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    /**
     * Fallback method for endpoints returning a single Status.
     * Returns a 503 Service Unavailable.
     * @param t The throwable that caused the circuit breaker to open.
     * @return A ResponseEntity with HTTP status 503.
     */
    public ResponseEntity<Status> fallbackStatus(Throwable t) {
        // You can add logging here to record the error
        // log.error("Circuit breaker for single status is open. Fallback executed.", t);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
