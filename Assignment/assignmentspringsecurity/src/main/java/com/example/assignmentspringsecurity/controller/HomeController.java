package com.example.assignmentspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String showHome(){
        return "home";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }



}
