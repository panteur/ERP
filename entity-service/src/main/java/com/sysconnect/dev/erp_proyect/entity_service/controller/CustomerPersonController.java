package com.sysconnect.dev.erp_proyect.entity_service.controller;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerPersonDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import com.sysconnect.dev.erp_proyect.entity_service.service.CustomerService;
import com.sysconnect.dev.erp_proyect.entity_service.service.EntitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerPerson")
public class CustomerPersonController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EntitieService entitieService;

   @RequestMapping("/rut/{rut}")
    public ResponseEntity<CustomerPersonDto> findByRut(@PathVariable String rut) {
       Entitie entitieDB = entitieService.findByRut(rut);
       if (entitieDB == null) return ResponseEntity.noContent().build();
           Customer customerDB = customerService.findByEntitie_Id(entitieDB.getId());
           return ResponseEntity.ok(customerDB);
   }

   @RequestMapping("/all")
   public ResponseEntity<List<CustomerPersonDto>> findAll() {
       return ResponseEntity.noContent().build();
   }



}
