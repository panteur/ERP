package com.sysconnect.dev.erp_proyect.master_data_service.controller;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Commune;
import com.sysconnect.dev.erp_proyect.master_data_service.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commune")
@CrossOrigin(origins = "http://localhost:4200")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Commune> getCommuneById(@PathVariable("id") Long id) {
        Commune communeBD = communeService.findById(id);
        if (communeBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeBD);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.findAll();
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Commune>> getCommuneByName(@PathVariable("name") String name){
        List<Commune> communeList = communeService.findByName(name);
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }

    @GetMapping("/regionid/{id}")
    public ResponseEntity<List<Commune>> getCommuneByRegionId(@PathVariable("pid") Long id){
        List<Commune> communeList = communeService.findByRegionId(id);
        if (communeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(communeList);
    }

    @PostMapping
    public ResponseEntity<Commune> createCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.create(commune);
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

    @PutMapping
    public ResponseEntity<Commune> updateCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.update(commune);
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

    @DeleteMapping
    public ResponseEntity<Commune> deleteCommune(@RequestBody Commune commune){
        Commune communeDB = communeService.delete(commune.getId());
        if (communeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communeDB);
    }

































}
