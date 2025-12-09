package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreateDto {

    private Long id;

    private String rut;

    private String entityType;

    private String names;

    private String lastNames;

    private Date birthDate;

    private Sex sex;

}
