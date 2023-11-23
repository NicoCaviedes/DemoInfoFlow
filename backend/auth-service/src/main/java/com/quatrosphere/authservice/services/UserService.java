package com.quatrosphere.authservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quatrosphere.authservice.configs.UserAuthProvider;
import com.quatrosphere.authservice.exceptions.AppException;
import com.quatrosphere.authservice.mapers.UserMapper;
import com.quatrosphere.authservice.models.dtos.UserDto;
import com.quatrosphere.authservice.models.entities.UserEntity;
import com.quatrosphere.authservice.models.records.UserLoginRecord;
import com.quatrosphere.authservice.models.records.UserRegisterRecord;
import com.quatrosphere.authservice.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService extends BaseService<UserEntity>{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthProvider authProvider;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, UserAuthProvider authProvider) {
        super(userRepository);

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authProvider = authProvider;
    }

    public UserDto loginUser(UserLoginRecord userLogin) {
        UserEntity userEntity = userRepository.findByEmail(userLogin.emailClient())
            .orElseThrow(() -> new AppException("Usuario Desconocido", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(userLogin.passwordClient(), userEntity.getPasswordClient()))
            return userMapper.toUserDto(userEntity);

        throw new AppException("Contrasena Invalida", HttpStatus.BAD_REQUEST);
    }

    public UserDto registerUser(UserRegisterRecord userRegister){
        Optional<UserEntity> userOpt = userRepository.findByEmail(userRegister.emailClient());

        if(userOpt.isPresent())
            throw new AppException("Usuario ya existe", HttpStatus.BAD_REQUEST);


        UserEntity userSave = userMapper.fromRecordToUserEntity(userRegister);
        userSave.setPasswordClient(passwordEncoder.encode(userSave.getPasswordClient()));
        userSave.setTokenAuthClient(authProvider.createToken(userMapper.toUserDto(userSave)));
        userSave = save(userSave);
        return userMapper.toUserDto(userSave);
    }
}
