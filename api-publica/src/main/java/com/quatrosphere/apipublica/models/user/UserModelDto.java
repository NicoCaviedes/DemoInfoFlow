package com.quatrosphere.apipublica.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data @ToString
public class UserModelDto {

    private long idUser;
    private String emailUser;
    private String passwordUser;
    private String passConfUser;
}
