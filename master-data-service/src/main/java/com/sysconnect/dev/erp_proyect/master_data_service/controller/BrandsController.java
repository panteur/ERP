package com.sysconnect.dev.erp_proyect.master_data_service.controller;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Brands;
import com.sysconnect.dev.erp_proyect.master_data_service.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;


    @GetMapping("/id/{id}")
    public ResponseEntity<Brands> getBrandsById(@PathVariable("id") Long id) {
        Brands brandsBD = brandsService.findById(id);
        if (brandsBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(brandsBD);
    }

    @GetMapping("/codint/{codint}")
    public ResponseEntity<Brands> getBrandsByCodint(@PathVariable("codint") String codint) {
        Brands brandsBD = brandsService.findByCodint(codint);
        if (brandsBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(brandsBD);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Brands>> getAllBrands() {
        List<Brands> brandsList = brandsService.findAll();
        if (brandsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brandsList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Brands>> getByNameContains(@PathVariable("name") String name) {
        List<Brands> brandsList = brandsService.findByNameContainsIgnoreCase(name);
        if (brandsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brandsList);
    }



    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    public ResponseEntity<List<Brands>> getBrandsByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<Brands> brandsList = brandsService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (brandsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brandsList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    public ResponseEntity<List<Brands>> getBrandsByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<Brands> brandsList = brandsService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (brandsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(brandsList);
    }

    @PostMapping
    public ResponseEntity<Brands> createBrands(@RequestBody Brands brands){
        Brands brandsDB = brandsService.saveBrands(brands);
        if (brandsDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(brandsDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Brands> updateBrands(@PathVariable("id") Long id, @RequestBody Brands brands) {
        brands.setId(id);
        Brands brandsDB = brandsService.updateBrands(brands);
        if (brandsDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(brandsDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Brands> deleteBrands(@PathVariable("id") Long id) {
        Brands brandsDB = brandsService.deleteBrands(id);
        if (brandsDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(brandsDB);
    }
}
