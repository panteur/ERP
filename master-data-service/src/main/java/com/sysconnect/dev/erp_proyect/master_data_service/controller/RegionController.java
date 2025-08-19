package com.sysconnect.dev.erp_proyect.master_data_service.controller;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Region;
import com.sysconnect.dev.erp_proyect.master_data_service.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/region")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

    @Autowired
    private RegionService regionService;


    @GetMapping("/id/{id}")
    public ResponseEntity<Region> getStatusById(@PathVariable("id") Long id) {
        Region regionBD = regionService.findById(id);
        if (regionBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionBD);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Region>> getAllRegion() {
        List<Region> regionList = regionService.findAll();
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Region>> getRegionByName(@PathVariable("name") String name) {

        List<Region> regionList = regionService.findByName(name);
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @GetMapping("/ordinal/{ordinal}")
    public ResponseEntity<List<Region>> getRegionByOrdinal(@PathVariable("ordinal") String num) {
        List<Region> regionList = regionService.findByOrdinal(num);
        if (regionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regionList);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region regionDB = regionService.create(region);
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

    @PutMapping
    public ResponseEntity<Region> updateRegion(@RequestBody Region region) {
        Region regionDB = regionService.update(region);
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

    @DeleteMapping
    public ResponseEntity<Region> deleteRegion(@RequestBody Region region) {
        Region regionDB = regionService.delete(region.getId());
        if (regionDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(regionDB);
    }

}