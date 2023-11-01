package com.quatrosphere.apipublica.models.customer;

import com.quatrosphere.apipublica.models.base.BaseModel;
import com.quatrosphere.apipublica.models.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "empresa")
@Data @ToString
@EqualsAndHashCode(callSuper=false)
public class CustomerModel extends BaseModel {

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
    private List<UserModel> listEmployees;

    @Override
    public CustomerModelDto transferToDto() {
        CustomerModelDto customerTrf = new CustomerModelDto();
        customerTrf.setIdEmpresa(this.idEmpresa);
        customerTrf.setRutEmpresa(this.rutEmpresa);
        customerTrf.setNombreEmpresa(this.nombreEmpresa);
        customerTrf.setDireccionEmpresa(this.direccionEmpresa);
        customerTrf.setFonoEmpresa(this.fonoEmpresa);

        return null;
    }
}
