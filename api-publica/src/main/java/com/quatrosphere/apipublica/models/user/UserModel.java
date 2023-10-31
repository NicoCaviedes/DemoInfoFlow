package com.quatrosphere.apipublica.models.user;

import com.quatrosphere.apipublica.models.customer.CustomerModel;
import com.quatrosphere.apipublica.models.inventory.InventoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data @ToString
public class UserModel {

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
    private CustomerModel comercio;

    public UserModelDto transferToDto(){
        UserModelDto userTrf = new UserModelDto();
        userTrf.setIdUser(this.idUser);
        userTrf.setEmailUser(this.emailUser);
        userTrf.setPasswordUser(this.passwordUser);
        userTrf.setPassConfUser(this.passConfUser);

        return userTrf;
    }
}
