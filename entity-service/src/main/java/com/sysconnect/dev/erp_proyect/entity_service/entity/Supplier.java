package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentShape;
import com.sysconnect.dev.erp_proyect.entity_service.enums.paymentMethod;
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

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @Transient
    private Status status;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id")
    private Entitie parent;

    @Temporal(TemporalType.DATE)
    @Column(name = "first_purchase")
    private Date firstPurchase;

    @Enumerated
    @Column(name = "medio_pago", nullable = false)
    private paymentMethod paymentMethod;

    @Enumerated
    @Column(name = "forma_pago", nullable = false)
    private paymentShape paymentShape;

    @Column(name = "pay_day")
    private int payDay;

}