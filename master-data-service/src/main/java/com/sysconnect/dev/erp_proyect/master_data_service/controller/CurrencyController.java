package com.sysconnect.dev.erp_proyect.master_data_service.controller;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Currency;
import com.sysconnect.dev.erp_proyect.master_data_service.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/currency")
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable("id") Long id){
        Currency currencyBD = currencyService.findById(id);
        if(currencyBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(currencyBD);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Currency>> getAllCurrency(){
        List<Currency> currencyList = currencyService.findAll();
        if(currencyList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(currencyList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Currency>> getCurrencyByName(@PathVariable("name") String name){
        List<Currency> currencyList = currencyService.findByName(name);
        if(currencyList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(currencyList);
    }

    @PostMapping
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency){
        Currency currencyDB = currencyService.create(currency);
        if(currencyDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(currencyDB);
    }

    @PutMapping
    public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency){
        Currency currencyDB = currencyService.update(currency);
        if(currencyDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(currencyDB);
    }

    @DeleteMapping
    public ResponseEntity<Currency> deleteCurrency(@RequestBody Currency currency){
        Currency currencyDB = currencyService.delete(currency.getId());
        if(currencyDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(currencyDB);
    }



}
