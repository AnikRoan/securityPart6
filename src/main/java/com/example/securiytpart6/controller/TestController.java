package com.example.securiytpart6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")// build group
public class TestController {
    @GetMapping("/test1")
    public String demo(){
        return "Hali-Alo!";
    }

    @GetMapping("/test2")
    public String demo2(){
        return "Next-Method!";
    }
}
