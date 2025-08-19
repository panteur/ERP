package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadStatusCustomer {

    @Autowired
    private StatusTypeRepository statusTypeRepository;
    @Autowired
    private StatusRepository statusRepository;

    public void loadStatusCustomer() {

        Status status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(3L,"STS_CLI_ACTIVO")) {
            status.setCodint("STS_CLI_ACTIVO");
            status.setName("ACTIVO");
            status.setDescription("Cliente Activo");
            status.setStatusType(statusTypeRepository.findById(3L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(3L,"STS_CLI_INACTIVO")) {
            status.setCodint("STS_CLI_INACTIVO");
            status.setName("INACTIVO");
            status.setDescription("Cliente Inactivo");
            status.setStatusType(statusTypeRepository.findById(3L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(3L,"STS_CLI_SUSPENDIDO")) {
            status.setCodint("STS_CLI_SUSPENDIDO");
            status.setName("SUSPENDIDO");
            status.setDescription("Cliente Suspendido debido a su conducta");
            status.setStatusType(statusTypeRepository.findById(3L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(3L,"STS_CLI_POR_ELIMINAR")) {
            status.setCodint("STS_CLI_POR_ELIMINAR");
            status.setName("POR_ELIMINAR");
            status.setDescription("Cliente sin actividad por mucho tiempo");
            status.setStatusType(statusTypeRepository.findById(3L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(3L,"STS_CLI_ELIMINADO")) {
            status.setCodint("STS_CLI_ELIMINADO");
            status.setName("ELIMINADO");
            status.setDescription("Cliente Eliminado");
            status.setStatusType(statusTypeRepository.findById(3L).orElse(null));
            statusRepository.save(status);
        }

    }


}
