package com.sysconnect.dev.erp_proyect.master_data_service.controller;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.service.RegionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/region")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

    private static final String CIRCUIT_BREAKER_NAME = "region";

    @Autowired
    private RegionService regionService;


    @GetMapping("/id/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegion")
    public ResponseEntity<Region> getStatusById(@PathVariable("id") Long id) {
        Region regionBD = regionService.findById(id);
        if (regionBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionBD);
    }

    @GetMapping("/list")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegionList")
    public ResponseEntity<List<Region>> getAllRegion() {
        List<Region> regionList = regionService.findAll();
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @GetMapping("/name/{name}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegionList")
    public ResponseEntity<List<Region>> getRegionByName(@PathVariable("name") String name) {

        List<Region> regionList = regionService.findByName(name);
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @GetMapping("/ordinal/{ordinal}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegionList")
    public ResponseEntity<List<Region>> getRegionByOrdinal(@PathVariable("ordinal") String num) {
        List<Region> regionList = regionService.findByOrdinal(num);
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @PostMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegion")
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region regionDB = regionService.create(region);
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

    @PutMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegion")
    public ResponseEntity<Region> updateRegion(@RequestBody Region region) {
        Region regionDB = regionService.update(region);
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

    @DeleteMapping
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackRegion")
    public ResponseEntity<Region> deleteRegion(@RequestBody Region region) {
        Region regionDB = regionService.delete(region.getId());
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

    // --- Fallback Methods ---
    public ResponseEntity<List<Region>> fallbackRegionList(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
    }

    public ResponseEntity<Region> fallbackRegion(Throwable t) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
