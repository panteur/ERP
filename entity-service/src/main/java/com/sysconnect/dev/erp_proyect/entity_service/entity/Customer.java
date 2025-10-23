package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.EmailStatus;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "entitie_id", nullable = false, unique = true)
    private Entitie entitie;

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id")
    private Entitie parent;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_purchase")
    private Date lastPurchase;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "email_status", nullable = false)
    private EmailStatus emailStatus = EmailStatus.REGISTRADO;

}