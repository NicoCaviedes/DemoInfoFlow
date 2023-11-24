package com.quatrosphere.authservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quatrosphere.authservice.configs.UserAuthProvider;
import com.quatrosphere.authservice.models.dtos.UserDto;
import com.quatrosphere.authservice.models.records.UserLoginRecord;
import com.quatrosphere.authservice.models.records.UserRegisterRecord;
import com.quatrosphere.authservice.services.UserService;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthProvider authProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserLoginRecord userLogin){
        UserDto user = userService.loginUser(userLogin);
        user.setTokenAuthClient(authProvider.createToken(user));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }   
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserRegisterRecord userRegister) {
        UserDto userRegistered = userService.registerUser(userRegister);
        return new ResponseEntity<>(userRegistered, HttpStatus.OK);
    }
    
}
