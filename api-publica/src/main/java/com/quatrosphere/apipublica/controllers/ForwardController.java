package com.quatrosphere.apipublica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

<<<<<<< Updated upstream
    @GetMapping(value = {"/login","/inventory","dashboard"})
=======
    @GetMapping(value = {"/","/login","/inventory","dashboard"})
>>>>>>> Stashed changes
    public String frontend(){
        return "forward:/";
    }
}
