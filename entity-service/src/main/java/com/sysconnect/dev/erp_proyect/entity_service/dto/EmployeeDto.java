package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.enums.ContractType;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Nationality;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import com.sysconnect.dev.erp_proyect.entity_service.model.Status;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeDto {

    private Long id;

    private String rut;

    private String names;

    private String lastNames;

    private Date birthDate;

    private Sex sex;

    private Nationality nationality;

    private ContractType contractType;

    private Date endContract;

    private Long statusId;

    private Status status;


}
