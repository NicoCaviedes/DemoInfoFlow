package com.quatrosphere.authservice.mapers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.quatrosphere.authservice.models.dtos.UserDto;
import com.quatrosphere.authservice.models.entities.UserEntity;
import com.quatrosphere.authservice.models.records.UserRegisterRecord;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "idCompany", source = "userEntity.company.idCompany")
    public UserDto toUserDto(UserEntity userEntity);

    public UserEntity fromRecordToUserEntity(UserRegisterRecord userRegister);

}
