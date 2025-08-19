package com.sysconnect.dev.erp_proyect.master_data_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_type_id")
    private StatusType statusType;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "codint", length = 50)
    private String codint;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "create_at")
    private Timestamp createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Timestamp updateAt;


}