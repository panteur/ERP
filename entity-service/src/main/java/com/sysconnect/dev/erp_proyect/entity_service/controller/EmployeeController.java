package com.sysconnect.dev.erp_proyect.entity_service.controller;


import com.sysconnect.dev.erp_proyect.entity_service.dto.EmployeeDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.service.EntitieService;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import com.sysconnect.dev.erp_proyect.entity_service.utils.CapitalizeWords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sysconnect.dev.erp_proyect.entity_service.service.EmployeeService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EntitieService entitieService;


}