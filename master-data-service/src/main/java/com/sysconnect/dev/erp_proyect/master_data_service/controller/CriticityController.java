package com.sysconnect.dev.erp_proyect.master_data_service.controller;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Criticity;
import com.sysconnect.dev.erp_proyect.master_data_service.service.CriticityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/criticity")
@CrossOrigin(origins = "http://localhost:4200")
public class CriticityController {

    @Autowired
    private CriticityService criticityService;


    @GetMapping("/id/{id}")
    public ResponseEntity<Criticity> getCriticityById(@PathVariable("id") Long id) {
        Criticity criticityDB = criticityService.findById(id);
        if (criticityDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(criticityDB);
    }

    @GetMapping("/codint/{codint}")
    public ResponseEntity<Criticity> getCriticityById(@PathVariable("codint") String codint) {
        Criticity criticityDB = criticityService.findByCodint(codint);
        if (criticityDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(criticityDB);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Criticity>> getAllBrands() {
        List<Criticity> criticityList = criticityService.findAll();
        if (criticityList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(criticityList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Criticity>> getByNameContains(@PathVariable("name") String name) {
        List<Criticity> criticityList = criticityService.findByNameContainsIgnoreCase(name);
        if (criticityList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(criticityList);
    }

    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    public ResponseEntity<List<Criticity>> getCriticityByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<Criticity> criticityList = criticityService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (criticityList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(criticityList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    public ResponseEntity<List<Criticity>> getCriticityByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<Criticity> criticityList = criticityService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (criticityList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(criticityList);
    }

    @PostMapping
    public ResponseEntity<Criticity> createCriticity(@RequestBody Criticity criticity){
        Criticity criticityDB = criticityService.createCriticity(criticity);
        if (criticityDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(criticityDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Criticity> updateCriticity(@PathVariable("id") Long id, @RequestBody Criticity criticity) {
        criticity.setId(id);
        Criticity criticityDB = criticityService.updateCriticity(criticity);
        if (criticityDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(criticityDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Criticity> deleteCriticity(@PathVariable("id") Long id) {
        Criticity criticityDB = criticityService.deleteCriticity(id);
        if (criticityDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(criticityDB);
    }

}
