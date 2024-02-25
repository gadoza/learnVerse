package com.example.learnverse.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class TestController {

    @GetMapping("user")
    public String helloUser(){
        return "hello user";
    }
}
