package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCompanyDto {

    private Long id;

    private String rut;

    private String socialRazon;

    private String fantasyName;

    private Set<String> giros;

    private Long statusId;

    private Entitie parent;

    private Date lastPurchase;

    private String email;


}
