package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.ContractType;
import com.sysconnect.dev.erp_proyect.entity_service.model.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "entitie_id", nullable = false, unique = true)
    private Entitie entitie;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private ContractType contractType;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_contract")
    private Date endContract;

    //Status from master-data-service
    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;


}