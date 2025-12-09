package com.sysconnect.dev.erp_proyect.entity_service.entity;

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
@Table(name = "supplier")
public class Supplier {
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

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;

    @Temporal(TemporalType.DATE)
    @Column(name = "first_purchase")
    private Date firstPurchase;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_purchase")
    private Date lastPurchase;


}