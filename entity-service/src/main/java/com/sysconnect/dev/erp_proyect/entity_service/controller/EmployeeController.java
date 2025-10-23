package com.sysconnect.dev.erp_proyect.entity_service.controller;


import com.sysconnect.dev.erp_proyect.entity_service.dto.EmployeeDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import com.sysconnect.dev.erp_proyect.entity_service.service.EntitieService;
import com.sysconnect.dev.erp_proyect.entity_service.service.PersonService;
import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import com.sysconnect.dev.erp_proyect.entity_service.utils.CapitalizeWords;
import com.sysconnect.dev.erp_proyect.entity_service.utils.EmployeeToEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sysconnect.dev.erp_proyect.entity_service.service.EmployeeService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EntitieService entitieService;

    @Autowired
    private PersonService personService;

    @Autowired
    private EmployeeToEmployeeDto employeeToEmployeeDto;

    @GetMapping("/byrut/{rut}")
    public ResponseEntity<EmployeeDto> findByRut(@PathVariable String rut) {
        Entitie entitieDB = entitieService.findByRut(rut);
        if (entitieDB == null) return ResponseEntity.notFound().build();
        Employee employeeDB = employeeService.findByEntitie_Id(entitieDB.getId());
        if (employeeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(employeeToEmployeeDto.toDto(employeeDB));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        System.err.println(employeeList.size());
        if (employeeList.isEmpty()) return ResponseEntity.noContent().build();
        List<EmployeeDto> lDto = employeeToEmployeeDto.toList(employeeList);
        if(lDto.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.OK).body(lDto);
    }

    @PostMapping("/create_employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        new Entitie();
        Entitie entitieDB = entitieService.save(Entitie.builder()
                .rut(employeeDto.getRut())
                .entitieType(EntitieType.PERSONA)
                .build());

        Person personDB = personService.save(Person.builder()
                .entitie(entitieDB)
                .names(CapitalizeWords.capitalize(employeeDto.getNames()))
                .lastNames(CapitalizeWords.capitalize(employeeDto.getLastNames()))
                .birthDate(employeeDto.getBirthDate())
                .sex(employeeDto.getSex())
                .nationality(employeeDto.getNationality())
                .build());

        Employee employeeDB = employeeService.save(Employee.builder()
                .entitie(entitieDB)
                .contractType(employeeDto.getContractType())
                .endContract(employeeDto.getEndContract())
                .statusId(employeeDto.getStatusId())
                .build());

        employeeDto.setId(entitieDB.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @PutMapping("/update_status/{id}/{statusId}")
    public ResponseEntity<EmployeeDto> updateStatus(@PathVariable Long id, @PathVariable Long statusId) {
        Employee employeeDB = employeeService.updateStatus(id, statusId);
        if (employeeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(employeeToEmployeeDto.toDto(employeeDB));
    }

    @PutMapping("/update_end_contract/{id}/{endContract}")
    public ResponseEntity<EmployeeDto> updateEndContract(@PathVariable Long id, @PathVariable Date endContract) {
        Employee employeeDB = employeeService.updateEndContract(id, endContract);
        if (employeeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(employeeToEmployeeDto.toDto(employeeDB));
    }

    @PutMapping("/update_contract_type/{id}/{contractType}")
    public ResponseEntity<EmployeeDto> updateContractType(@PathVariable Long id, @PathVariable String contractType) {
        Employee employeeDB = employeeService.updateContractType(id, contractType);
        if (employeeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(employeeToEmployeeDto.toDto(employeeDB));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Entitie entitieDB = entitieService.findById(employeeDto.getId());
        if (entitieDB == null) return ResponseEntity.notFound().build();
        Person personDB = personService.findByEntitie_Id(employeeDto.getId());
        if (personDB == null) return ResponseEntity.notFound().build();
        personDB.setNames(employeeDto.getNames());
        personDB.setLastNames(employeeDto.getLastNames());
        personDB.setBirthDate(employeeDto.getBirthDate());
        personDB.setSex(employeeDto.getSex());
        personDB.setNationality(employeeDto.getNationality());
        personService.save(personDB);
        Employee employeeDB = employeeService.findByEntitie_Id(employeeDto.getId());
        if (employeeDB == null) return ResponseEntity.notFound().build();
        employeeDB.setContractType(employeeDto.getContractType());
        employeeDB.setEndContract(employeeDto.getEndContract());
        employeeDB.setStatusId(employeeDto.getStatusId());
        employeeService.save(employeeDB);

        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);

    }

    @DeleteMapping(value = "/{rut}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable String rut){
        Entitie entitieDB = entitieService.findByRut(rut);
        if (entitieDB == null) return ResponseEntity.notFound().build();
        Person personDB = personService.findByEntitie_Id(entitieDB.getId());
        if (personDB == null) return ResponseEntity.notFound().build();
        Employee employeeDB = employeeService.findByEntitie_Id(entitieDB.getId());
        if (employeeDB == null) return ResponseEntity.notFound().build();
        employeeService.delete(employeeDB.getId());
        personService.delete(personDB.getId());
        entitieService.delete(entitieDB.getId());
        return ResponseEntity.ok().build();
    }


}