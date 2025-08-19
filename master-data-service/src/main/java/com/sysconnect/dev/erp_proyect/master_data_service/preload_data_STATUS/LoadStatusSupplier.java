package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadStatusSupplier {

    @Autowired
    private StatusTypeRepository statusTypeRepository;
    @Autowired
    private StatusRepository statusRepository;

    public void loadStatusSupplier() {

        Status status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(4L,"STS_PROV_ACTIVO")) {
            status.setCodint("STS_PROV_ACTIVO");
            status.setName("ACTIVO");
            status.setDescription("Proveedor Activo");
            status.setStatusType(statusTypeRepository.findById(4L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(4L,"STS_PROV_INACTIVO")) {
            status.setCodint("STS_PROV_INACTIVO");
            status.setName("INACTIVO");
            status.setDescription("Proveedor Inactivo por algun tiempo");
            status.setStatusType(statusTypeRepository.findById(4L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(4L,"STS_PROV_SUSPENDIDO")) {
            status.setCodint("STS_PROV_SUSPENDIDO");
            status.setName("SUSPENDIDO");
            status.setDescription("Proveedor suspendido por alguna razon");
            status.setStatusType(statusTypeRepository.findById(4L).orElse(null));
            statusRepository.save(status);
        }


        //POR_ELIMINAR
        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(4L,"STS_PROV_POR_ELIMINAR")) {
            status.setCodint("STS_PROV_POR_ELIMINAR");
            status.setName("POR_ELIMINAR");
            status.setDescription("Proveedor por eliminar");
            status.setStatusType(statusTypeRepository.findById(4L).orElse(null));
            statusRepository.save(status);
        }

        //ELIMINADO
        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(4L,"STS_PROV_ELIMINADO")) {
            status.setCodint("STS_PROV_ELIMINADO");
            status.setName("ELIMINADO");
            status.setDescription("Proveedor eliminado");
            status.setStatusType(statusTypeRepository.findById(4L).orElse(null));
            statusRepository.save(status);
        }



    }
}
