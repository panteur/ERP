package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadStatusUser {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StatusTypeRepository statusTypeRepository;

    public void loadUserStatus(){

        Status status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(1L,"STS_USR_ACTIVO")){
            status.setCodint("STS_USR_ACTIVO");
            status.setName("ACTIVO");
            status.setDescription("Estado de usuario Activo");
            status.setStatusType(statusTypeRepository.findById(1L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(1L,"STS_USR_TEMP_ACTIVO")){
            status.setCodint("STS_USR_TEMP_ACTIVO");
            status.setName("TEMP_ACTIVO");
            status.setDescription("Estado de usuario ACTIVO, en caso de usuarios temporales");
            status.setStatusType(statusTypeRepository.findById(1L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(1L,"STS_USR_SUSPENDIDO")){
            status.setCodint("STS_USR_SUSPENDIDO");
            status.setName("SUSPENDIDO");
            status.setDescription("Estado de usuario Inactivo");
            status.setStatusType(statusTypeRepository.findById(1L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(1L,"STS_USR_BLOQUEADO")){
            status.setCodint("STS_USR_BLOQUEADO");
            status.setName("BLOQUEADO");
            status.setDescription("Estado de usuario Bloqueado");
            status.setStatusType(statusTypeRepository.findById(1L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(1L,"STS_USR_TEMPORAL_VENCIDO")){
            status.setCodint("STS_USR_TEMP_VENCIDO");
            status.setName("TEMP_VENCIDO");
            status.setDescription("Estado de usuario VENCIDO, en caso de usuarios temporales");
            status.setStatusType(statusTypeRepository.findById(1L).orElse(null));
            statusRepository.save(status);
        }

    }

}
