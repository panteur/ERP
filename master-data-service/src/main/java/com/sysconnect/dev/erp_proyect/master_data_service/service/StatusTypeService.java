package com.sysconnect.dev.erp_proyect.master_data_service.service;



import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;

import java.sql.Timestamp;
import java.util.List;

public interface StatusTypeService {

    public StatusType findById(Long id);
    public Long count(Long id);


    public List<StatusType> findAll();
    public List<StatusType> findByNameContainsIgnoreCase(String name);
    public List<StatusType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd);
    public List<StatusType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd);

    public StatusType createStatusType(StatusType statusType);
    public StatusType updateStatusType(StatusType statusType);
    public StatusType deleteStatusType(Long id);


}
