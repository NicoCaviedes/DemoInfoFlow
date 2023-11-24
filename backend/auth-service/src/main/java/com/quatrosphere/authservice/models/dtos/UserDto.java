package com.quatrosphere.authservice.models.dtos;

import lombok.*;

@Data @Builder
public class UserDto {
    

    private long idClient; 
    private String firstNameClient;
    private String lastNameClient;
    private String emailClient;
    private String passwordClient;
    private String tokenAuthClient;
    private long idCompany;
    
}
