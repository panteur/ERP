package com.sysconnect.dev.erp_proyect.master_data_service.controller;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    @Autowired
    private StatusService statusService;


    @GetMapping("/id/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable("id") Long id) {
        Status statusBD = statusService.findById(id);
        if (statusBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusBD);
    }

    @GetMapping("/codint/{codint}")
    public ResponseEntity<Status> getStatusByCodint(@PathVariable("codint") String codint) {
        Status statusBD = statusService.findByCodint(codint);
        if (statusBD == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusBD);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statusList = statusService.findAll();
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/status_type_id/{id}")
    public ResponseEntity<List<Status>> getByStatusTypeId(@PathVariable("id") Long id) {
        List<Status> statusList = statusService.findByStatusType_Id(id);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Status>> getByNameContains(@PathVariable("name") String name) {
        List<Status> statusList = statusService.findByNameIgnoreCase(name);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/register_at_between/{registerAtStart}/{registerAtEnd}")
    public ResponseEntity<List<Status>> getStatusByRegisterAtBetween(@PathVariable("registerAtStart") Timestamp registerAtStart, @PathVariable("registerAtEnd") Timestamp registerAtEnd) {
        List<Status> statusList = statusService.findByCreateAtBetween(registerAtStart, registerAtEnd);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/update_at_between/{updateAtStart}/{updateAtEnd}")
    public ResponseEntity<List<Status>> getStatusByUpdateAtBetween(@PathVariable("updateAtStart") Timestamp updateAtStart, @PathVariable("updateAtEnd") Timestamp updateAtEnd) {
        List<Status> statusList = statusService.findByUpdateAtBetween(updateAtStart, updateAtEnd);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(statusList);
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status){
        Status statusDB = statusService.createStatusService(status);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(statusDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable("id") Long id, @RequestBody Status status) {
        status.setId(id);
        Status statusDB = statusService.updateStatus(status);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Status> deleteStatus(@PathVariable("id") Long id) {
        Status statusDB = statusService.deleteStatus(id);
        if (statusDB == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(statusDB);
    }

}
