package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;
import com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS.*;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StatusTypeServiceImpl implements StatusTypeService {

    @Autowired
    private StatusTypeRepository statusTypeRepository;

    @Autowired
    private LoadStatusType loadStatusType;

    @Autowired
    private LoadStatusUser loadStatusUser;

    @Autowired
    private LoadStatusEmployee loadStatusEmployee;

    @Autowired
    private LoadStatusCustomer loadStatusCustomer;

    @Autowired
    private LoadStatusSupplier loadStatusSupplier;

    @Override
    public StatusType findById(Long id) {
        return statusTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Long count(Long id) {
        return statusTypeRepository.countById(id);
    }

    @Override
    public List<StatusType> findAll() {
        return statusTypeRepository.findAll();
    }

    @Override
    public List<StatusType> findByNameContainsIgnoreCase(String name) {
        return statusTypeRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<StatusType> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return statusTypeRepository.findByCreateAtBetween(createAtStart, createAtEnd);
    }

    @Override
    public List<StatusType> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return statusTypeRepository.findByUpdateAtBetween(updateAtStart, updateAtEnd);
    }

    @Override
    public StatusType createStatusType(StatusType statusType) {
        return statusTypeRepository.save(statusType);
    }

    @Override
    public StatusType updateStatusType(StatusType statusType) {
        StatusType statusTypeDB = statusTypeRepository.findById(statusType.getId()).orElse(null);
        if (statusTypeDB == null) return null;
        statusTypeDB.setStatusTypeAbrev(statusType.getStatusTypeAbrev());
        statusTypeDB.setName(statusType.getName());
        statusTypeDB.setDescription(statusType.getDescription());
        return statusTypeRepository.save(statusTypeDB);
    }

    @Override
    public StatusType deleteStatusType(Long id) {
        StatusType statusTypeDB = statusTypeRepository.findById(id).orElse(null);
        if (statusTypeDB == null) return null;
        statusTypeRepository.delete(statusTypeDB);

        return statusTypeDB;
    }



}
