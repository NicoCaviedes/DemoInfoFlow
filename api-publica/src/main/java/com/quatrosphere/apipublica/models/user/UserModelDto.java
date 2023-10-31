package com.quatrosphere.apipublica.models.user;

import com.quatrosphere.apipublica.models.customer.CustomerModel;
import com.quatrosphere.apipublica.models.customer.CustomerModelDto;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data @ToString
@EqualsAndHashCode(callSuper=false)
public class UserModelDto {

    private long idUser;
    private String emailUser;
    private String passwordUser;
    private String passConfUser;
    private long idComercio;
}
