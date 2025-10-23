package com.sysconnect.dev.erp_proyect.entity_service.dto;

import com.sysconnect.dev.erp_proyect.entity_service.enums.Nationality;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentMethod;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentShape;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierPersonDto {

    private Long id;

    private String rut;

    private String names;

    private String lastNames;

    private Date birthDate;

    private Sex sex;

    private Nationality nationality;

    private Long statusId;

    private Date firstPurchase;

    private paymentMethod paymentMethod;

    private paymentShape paymentShape;

    private int payDay;
}
