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

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/private/sesion")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, UserModelDto>> loginUser(@RequestBody UserModelDto userLogin){
        Map<String, UserModelDto> result = new HashMap<>();

        try {
            UserModel userDatabase = userService.findByEmail(userLogin.getEmailUser());

            if (userDatabase == null || userLogin.getEmailUser().trim().isEmpty()) {
                result.put(LoginMessage.NOT_FOUND.getMessage(), null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else if (!userDatabase.getPasswordUser().equals(userLogin.getPasswordUser())) {
                result.put(LoginMessage.FOUND_NOT_EQUAL_PASS.getMessage(), null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.put(LoginMessage.USER_EXISTS.getMessage(), userDatabase.transferToDto());
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e){
            result.put(LoginMessage.INTERNAL_ERROR.getMessage(), null);
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
