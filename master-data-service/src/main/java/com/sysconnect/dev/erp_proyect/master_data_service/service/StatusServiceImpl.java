package com.sysconnect.dev.erp_proyect.master_data_service.service;


import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusRepository statusRepository;


    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public Long count(Long id) {
        return statusRepository.count();
    }

    @Override
    public Status findByCodint(String codint) {
        return statusRepository.findByCodint(codint);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public List<Status> findByStatusType_Id(Long id) {
        return statusRepository.findByStatusType_Id(id);
    }

    @Override
    public List<Status> findByNameIgnoreCase(String name) {
        return statusRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Status> findByCreateAtBetween(Timestamp createAtStart, Timestamp createAtEnd) {
        return statusRepository.findByCreateAtBetween(createAtStart,createAtEnd);
    }

    @Override
    public List<Status> findByUpdateAtBetween(Timestamp updateAtStart, Timestamp updateAtEnd) {
        return statusRepository.findByUpdateAtBetween(updateAtStart,updateAtEnd);
    }

    @Override
    public Status createStatusService(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status updateStatus(Status status) {
        Status statusDB = statusRepository.findById(status.getId()).orElse(null);
        if (statusDB == null) return null;
        statusDB.setStatusType(status.getStatusType());
        statusDB.setName(status.getName());
        statusDB.setCodint(status.getCodint());
        statusDB.setDescription(status.getDescription());

        return statusRepository.save(statusDB);
    }

    @Override
    public Status deleteStatus(Long id) {
        Status statusDB = statusRepository.findById(id).orElse(null);
        if (statusDB == null) return null;
        statusRepository.delete(statusDB);
        return statusDB;
    }
}
