package com.quatrosphere.apipublica.controllers;

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

@Controller
@RequestMapping("/api/private/sesion")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody UserModelDto userModelDto){
        try {
            UserModel userDatabase = userService.findByEmail(userModelDto.getEmailUser());

            if (userDatabase == null)
                return new ResponseEntity<>("", HttpStatus.OK);


            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
