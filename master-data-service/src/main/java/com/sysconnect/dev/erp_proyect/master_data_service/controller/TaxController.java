package com.sysconnect.dev.erp_proyect.master_data_service.controller;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Tax;
import com.sysconnect.dev.erp_proyect.master_data_service.service.TaxService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/tax")
@CrossOrigin(origins = "http://localhost:4200")
public class TaxController {

    private static final String CIRCUIT_BREAKER_NAME = "tax";

    @Autowired
    private TaxService taxService;

    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTax")
    public ResponseEntity<Tax> getTaxById(@PathVariable("id") Long id){
        Tax taxBD = taxService.findById(id);
        if(taxBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taxBD);
    }

    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTaxList")
    public ResponseEntity<List<Tax>> getAllTax(){
        List<Tax> taxList = taxService.findAll();
        if(taxList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(taxList);
    }

    @GetMapping("/abrev/{abrev}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTaxList")
    public ResponseEntity<List<Tax>> getTaxByAbrev(@PathVariable("abrev") String abrev){
        List<Tax> taxList = taxService.findByAbrev(abrev);
        if(taxList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(taxList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTax")
    public ResponseEntity<Tax> createTax(@RequestBody Tax tax){
        Tax taxDB = taxService.create(tax);
        if(taxDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taxDB);
    }

    @PutMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTax")
    public ResponseEntity<Tax> updateTax(@RequestBody Tax tax){
        Tax taxDB = taxService.update(tax);
        if(taxDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taxDB);
    }

    @DeleteMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackTax")
    public ResponseEntity<Tax> deleteTax(@RequestBody Tax tax){
        Tax taxDB = taxService.delete(tax.getId());
        if(taxDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taxDB);
    }

    // --- Fallback Methods ---
    public ResponseEntity<List<Tax>> fallbackTaxList(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    public ResponseEntity<Tax> fallbackTax(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
