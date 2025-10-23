package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Nationality;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPersonDto {

    private Long id;

    private String rut;

    private String names;

    private String lastNames;

    private Date birthDate;

    private Sex sex;

    private Nationality nationality;

    private Long statusId;

    private Entitie parent;

    private Date lastPurchase;


    private String email;

}
