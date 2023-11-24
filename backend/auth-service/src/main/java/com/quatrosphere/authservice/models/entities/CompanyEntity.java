package com.quatrosphere.authservice.models.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "company")
@Data @Builder
@EqualsAndHashCode(callSuper = false)
public class CompanyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private long idCompany;

    @Column(name = "rut_company")
    private String rutCompany;

    @Column(name = "name_company")
    private String nombreCompany;

    @Column(name = "direction_company")
    private String direccionCompany;

    @Column(name = "phone_company")
    private long fonoCompany;

    @OneToMany(mappedBy = "company")
    private List<UserEntity> listEmployees;
}
