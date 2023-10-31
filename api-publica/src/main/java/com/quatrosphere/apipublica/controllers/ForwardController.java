package com.quatrosphere.apipublica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    @GetMapping(value = {"/login","/inventory","dashboard"})
    public String frontend(){
        return "forward:/";
    }
}