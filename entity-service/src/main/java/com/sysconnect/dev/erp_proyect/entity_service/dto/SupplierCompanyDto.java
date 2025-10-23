package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentMethod;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentShape;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierCompanyDto {

    private Long id;

    private String rut;

    private String socialRazon;

    private String fantasyName;

    private Set<String> giros;

    private Long statusId;

    private Entitie parent;

    private Date firstPurchase;

    private paymentMethod paymentMethod;

    private paymentShape paymentShape;

    @Column(name = "pay_day")
    private int payDay;
}
