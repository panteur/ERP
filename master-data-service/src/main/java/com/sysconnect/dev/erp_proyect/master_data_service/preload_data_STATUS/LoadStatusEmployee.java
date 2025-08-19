package com.sysconnect.dev.erp_proyect.master_data_service.preload_data_STATUS;

import com.sysconnect.dev.erp_proyect.master_data_service.entity.Status;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusRepository;
import com.sysconnect.dev.erp_proyect.master_data_service.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadStatusEmployee {

    @Autowired
    private StatusTypeRepository statusTypeRepository;
    @Autowired
    private StatusRepository statusRepository;

    public void loadStatusEmployee() {

        Status status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_INDEFINIDO")) {
            status.setCodint("STS_EMPL_CONT_INDEFINIDO");
            status.setName("CONT_INDEFINIDO");
            status.setDescription("Empleado con contrato indefinido");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PLAZO_FIJO")) {
            status.setCodint("STS_EMPL_CONT_PLAZO_FIJO");
            status.setName("CONT_PLAZO_FIJO");
            status.setDescription("Empleado con contrato a plazo fijo");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PRACT")) {
            status.setCodint("STS_EMPL_CONT_PRACT");
            status.setName("CONT_PRACT");
            status.setDescription("Empleado con contrato de practicante");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PLAZO_FIJO_POR_VENCER")) {
            status.setCodint("STS_EMPL_CONT_PLAZO_FIJO_POR_VENCER");
            status.setName("PLAZO_FIJO_POR_VENCER");
            status.setDescription("Empleado con contrato a plazo fijo por vencer");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PRACT_POR_VENCER")) {
            status.setCodint("STS_EMPL_CONT_PRACT_POR_VENCER");
            status.setName("CONT_PRACT_POR_VENCER");
            status.setDescription("Empleado con contrato de practicante por vencer");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PLAZO_FIJO_VENCIDO")) {
            status.setCodint("STS_EMPL_CONT_PLAZO_FIJO_VENCIDO");
            status.setName("PLAZO_FIJO_VENCIDO");
            status.setDescription("Empleado con contrato a plazo fijo vencido");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_CONT_PRACT_VENCIDO")) {
            status.setCodint("STS_EMPL_CONT_PRACT_VENCIDO");
            status.setName("CONT_PRACT_VENCIDO");
            status.setDescription("Empleado con contrato de practicante vencido");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }

        status = new Status();
        if (!statusRepository.existsByStatusType_IdAndCodint(2L,"STS_EMPL_DESVINCULADO")) {
            status.setCodint("STS_EMPL_DESVINCULADO");
            status.setName("DESVINCULADO");
            status.setDescription("Empleado desvinculado");
            status.setStatusType(statusTypeRepository.findById(2L).orElse(null));
            statusRepository.save(status);
        }



    }
}
