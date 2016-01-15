package com.ksu.skillsup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class WelcomeController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "welcome";
    }

}
