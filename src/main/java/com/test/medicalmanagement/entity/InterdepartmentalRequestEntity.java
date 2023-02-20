package com.test.medicalmanagement.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interdepartmental_requests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterdepartmentalRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "responsible")
    private String responsible;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mmId")
    private MedicalManagementEntity medicalManagement;
}
