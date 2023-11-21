package com.quatrosphere.storeservice.models.entities.user;

import com.quatrosphere.storeservice.models.entities.customer.CustomerEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class UserEntity {
    
    @Id
    @Column(name = "id_user")
    private long idUser;

    @Column(name = "email_user")
    private String emailUser;

    @Column(name = "password")
    private String passwordUser;

    @Transient
    private String passConfUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private CustomerEntity comercio;

}
