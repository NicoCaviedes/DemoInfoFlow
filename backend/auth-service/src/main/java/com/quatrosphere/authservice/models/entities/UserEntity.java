package com.quatrosphere.authservice.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private long idClient;

    @Column(name = "firstname_client")
    private String firstNameClient;

    @Column(name = "lastname_client")
    private String lastNameClient;
    
    @Column(name = "email_client")
    private String emailClient;

    @Column(name = "password_client")
    private String passwordClient;

    @Column(name = "token_auth")
    private String tokenAuthClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private CompanyEntity company;
}
