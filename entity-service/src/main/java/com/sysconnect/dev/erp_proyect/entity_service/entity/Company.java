package com.sysconnect.dev.erp_proyect.entity_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "entitie_id", nullable = false, unique = true)
    private Entitie entitie;

    @Column(name = "social_razon", nullable = false)
    private String socialRazon;

    @Column(name = "fantasy_name", nullable = false)
    private String fantasyName;

    @ElementCollection
    @Column(name = "giro")
    @CollectionTable(name = "company_giros", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<String> giros = new LinkedHashSet<>();


}