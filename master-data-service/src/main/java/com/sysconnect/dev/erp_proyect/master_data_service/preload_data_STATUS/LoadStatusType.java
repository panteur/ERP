package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.StatusType;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadStatusType {

    @Autowired
    private StatusTypeRepository statusTypeRepository;


    public void loadStatusType() {

        StatusType statusType = new StatusType();
        if (!statusTypeRepository.existsByName("USUARIO")) {
            statusType.setStatusTypeAbrev("STS_USR");
            statusType.setName("USUARIO");
            statusType.setDescription("Tipo de Estado para Usuarios");
            statusTypeRepository.save(statusType);
        }

        statusType = new StatusType();
        if (!statusTypeRepository.existsByName("EMPLEADO")) {
            statusType.setStatusTypeAbrev("STS_EMPL");
            statusType.setName("EMPLEADO");
            statusType.setDescription("Tipo de Estado para Empleados");
            statusTypeRepository.save(statusType);
        }


        statusType = new StatusType();
        if (!statusTypeRepository.existsByName("CLIENTE")) {
            statusType.setStatusTypeAbrev("STS_CLI");
            statusType.setName("CLIENTE");
            statusType.setDescription("Tipo de Estado para Clientes");
            statusTypeRepository.save(statusType);
        }


        statusType = new StatusType();
        if (!statusTypeRepository.existsByName("PROVEEDOR")) {
            statusType.setStatusTypeAbrev("STS_PROV");
            statusType.setName("PROVEEDOR");
            statusType.setDescription("Tipo de Estado para Proveedores");
            statusTypeRepository.save(statusType);
        }

    }


}
