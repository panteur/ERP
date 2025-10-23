package com.sysconnect.dev.erp_proyect.entity_service.model;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Status {

    private String name;

    private String codint;

    private String description;
}
