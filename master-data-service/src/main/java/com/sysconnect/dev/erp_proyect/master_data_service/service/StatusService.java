package com.sysconnect.dev.erp_proyect.master_data_service.service;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;

import java.sql.Timestamp;
import java.util.List;

public interface StatusService {

    public Status findById(Long id);
    public Long count(Long id);
    public Status findByCodint(String codint);

    public List<Status> findAll();
    public List<Status> findByStatusType_Id(Long id);
    public List<Status> findByNameIgnoreCase(String name);
    public List<Status> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);
    public List<Status> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    public Status createStatusService(Status status);
    public Status updateStatus(Status status);
    public Status deleteStatus(Long id);

}
