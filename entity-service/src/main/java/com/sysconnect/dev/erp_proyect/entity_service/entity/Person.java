package com.sysconnect.dev.erp_proyect.entity_service.entity;

import com.sysconnect.dev.erp_proyect.entity_service.enums.Nationality;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "person")
public class Person {
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

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    @Column(name = "nationality", nullable = false)
    private Nationality nationality;

    //Register at
    @Column(name = "register_at", nullable = false)
    @CreationTimestamp
    private Timestamp registerAt;

    //Update at
    @Column(name = "update_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updateAt;



}