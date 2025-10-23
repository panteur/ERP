package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.EntitieType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "entitie")
public class Entitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private Timestamp updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "entitie_type", nullable = false)
    private EntitieType entitieType;

}