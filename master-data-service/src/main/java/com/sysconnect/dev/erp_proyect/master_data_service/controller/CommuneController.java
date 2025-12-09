package com.sysconnect.dev.erp_proyect.master_data_service.controller;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.service.CommuneService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/commune")
@CrossOrigin(origins = "http://localhost:4200")
public class CommuneController {

    private static final String CIRCUIT_BREAKER_NAME = "commune";

    @Autowired
    private CommuneService communeService;

    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommune")
    public ResponseEntity<Commune> getCommuneById(@PathVariable("id") Long id) {
        Commune communeBD = communeService.findById(id);
        if (communeBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeBD);
    }

    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommuneList")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.findAll();
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }


    @GetMapping("/name/{name}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommuneList")
    public ResponseEntity<List<Commune>> getCommuneByName(@PathVariable("name") String name){
        List<Commune> communeList = communeService.findByName(name);
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }

    @GetMapping("/regionid/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommuneList")
    public ResponseEntity<List<Commune>> getCommuneByRegionId(@PathVariable("id") Long id){
        List<Commune> communeList = communeService.findByRegionId(id);
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommune")
    public ResponseEntity<Commune> createCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.create(commune);
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

    @PutMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommune")
    public ResponseEntity<Commune> updateCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.update(commune);
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

    @DeleteMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackCommune")
    public ResponseEntity<Commune> deleteCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.delete(commune.getId());
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

    // --- Fallback Methods ---
    public ResponseEntity<List<Commune>> fallbackCommuneList(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    public ResponseEntity<Commune> fallbackCommune(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
