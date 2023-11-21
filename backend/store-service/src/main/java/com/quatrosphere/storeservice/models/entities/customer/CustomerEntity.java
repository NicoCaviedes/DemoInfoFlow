package com.quatrosphere.storeservice.models.entities.customer;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.BaseEntity;
import com.quatrosphere.storeservice.models.entities.user.UserEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "empresa")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class CustomerEntity extends BaseEntity{
    
    @Id
    @Column(name = "id_empresa")
    private long idEmpresa;

    @Column(name = "rut_empresa")
    private String rutEmpresa;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "direccion_empresa")
    private String direccionEmpresa;

    @Column(name = "fono_empresa")
    private long fonoEmpresa;

    @OneToMany(mappedBy = "comercio")
    private List<UserEntity> listEmployees;

    // public UserModelDto transferToDto(){
    //     UserModelDto userTrf = new UserModelDto();
    //     userTrf.setIdUser(this.idUser);
    //     userTrf.setEmailUser(this.emailUser);
    //     userTrf.setPasswordUser(this.passwordUser);
    //     userTrf.setPassConfUser(this.passConfUser);
    //     userTrf.setIdComercio(comercio.getIdEmpresa());
    //     return userTrf;
    // }

}
