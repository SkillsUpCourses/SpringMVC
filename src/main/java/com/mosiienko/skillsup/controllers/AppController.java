package com.mosiienko.skillsup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "contact";
    }

}
