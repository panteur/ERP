package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.CivilState;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
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

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "last_names", nullable = false)
    private String lastNames;

    //Status from master-data-service
    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    @Column(name = "civil_state", nullable = false)
    private CivilState civilState;

    @Temporal(TemporalType.DATE)
    @Column(name = "entry_date")
    private Date entryDate;


}