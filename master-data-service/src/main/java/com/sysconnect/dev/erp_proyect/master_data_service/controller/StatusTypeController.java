package com.sysconnect.dev.erp_proyect.master_data_service.controller;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;
import com.sysconnect.dev.erp_proyect.master_data_service.service.StatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/status_type")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusTypeController {

    @Autowired
    private StatusTypeService statusTypeService;


    @GetMapping("/id/{id}")
    public ResponseEntity<StatusType> getStatusTypeById(@PathVariable("id") Long id) {
        StatusType statusTypeBD = statusTypeService.findById(id);
        if (statusTypeBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeBD);
    }


    @GetMapping("/list")
    public ResponseEntity<List<StatusType>> getAllStatusType() {
        List<StatusType> statusTypeList = statusTypeService.findAll();
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<StatusType>> getByNameContains(@PathVariable("name") String name) {
        List<StatusType> statusTypeList = statusTypeService.findByNameContainsIgnoreCase(name);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }



    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    public ResponseEntity<List<StatusType>> getStatusTypeByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<StatusType> statusTypeList = statusTypeService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    public ResponseEntity<List<StatusType>> getStatusTypeByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<StatusType> statusTypeList = statusTypeService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (statusTypeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusTypeList);
    }

    @PostMapping
    public ResponseEntity<StatusType> createStatusType(@RequestBody StatusType statusType){
        StatusType statusTypeDB = statusTypeService.createStatusType(statusType);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(statusTypeDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StatusType> updateStatusType(@PathVariable("id") Long id, @RequestBody StatusType statusType) {
        statusType.setId(id);
        StatusType statusTypeDB = statusTypeService.updateStatusType(statusType);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StatusType> deleteStatusType(@PathVariable("id") Long id) {
        StatusType statusTypeDB = statusTypeService.deleteStatusType(id);
        if (statusTypeDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusTypeDB);
    }


}
