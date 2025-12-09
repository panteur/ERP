package com.sysconnect.dev.erp_proyect.entity_service.feignclients;

import com.sysconnect.dev.erp_proyect.entity_service.model.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "master-data-service", url = "http://localhost:8085/api/status")
public interface StatusFeignClient {

    @GetMapping("/id/{id}")
    public Status getStatus(@PathVariable("id") Long id);

    @GetMapping("/codint/{codint}")
    public ResponseEntity<Status> getStatusByCodint(@PathVariable("codint") String codint);

}
