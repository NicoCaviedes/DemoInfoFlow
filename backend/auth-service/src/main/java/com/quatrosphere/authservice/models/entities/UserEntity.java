package com.quatrosphere.authservice.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
@Builder
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "password_cliente")
    private String password;

    @Column(name = "token_auth")
    private String tokenAuth;
}
