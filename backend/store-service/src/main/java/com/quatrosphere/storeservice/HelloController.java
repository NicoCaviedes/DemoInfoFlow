package com.quatrosphere.storeservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class HelloController {
    
    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hola mundo desde java api rest", HttpStatus.OK);
    }
}
