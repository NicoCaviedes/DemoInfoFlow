package com.quatrosphere.apipublica.controllers;

import com.quatrosphere.apipublica.enums.LoginMessage;
import com.quatrosphere.apipublica.models.user.UserModel;
import com.quatrosphere.apipublica.models.user.UserModelDto;
import com.quatrosphere.apipublica.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/private/sesion")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<List<Object>> loginUser(@RequestBody UserModelDto userLogin){
        List<Object> result = new ArrayList<>();

        try {
            UserModel userDatabase = userService.findByEmail(userLogin.getEmailUser());
            if (userDatabase == null || userLogin.getEmailUser().trim().isEmpty()) {
                result.add(LoginMessage.NOT_FOUND.getMessage());
                result.add(null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else if (!userDatabase.getPasswordUser().equals(userLogin.getPasswordUser())) {
                result.add(LoginMessage.FOUND_NOT_EQUAL_PASS.getMessage());
                result.add(null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.add(LoginMessage.USER_EXISTS.getMessage());
                result.add(userDatabase.transferToDto());
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e){
            result.add(LoginMessage.INTERNAL_ERROR.getMessage());
            result.add(null);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
