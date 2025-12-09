package com.sysconnect.dev.erp_proyect.entity_service.controller;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerCreateDto;
import com.sysconnect.dev.erp_proyect.entity_service.dto.MessageDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.service.CustomerService;
import com.sysconnect.dev.erp_proyect.entity_service.service.EntitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

     @Autowired
     private EntitieService entitieService;

     @Autowired
     private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createCustomer(@RequestBody CustomerCreateDto customerCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerCreateDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCUstomer(){return ResponseEntity.ok(customerService.findAll());}


}
