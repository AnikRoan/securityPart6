package com.example.securiytpart6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")// build group
public class DemoController {
    @GetMapping("/demo1")
    public String demo(){
        return "Hali-Alo!";
    }

    @GetMapping("/demo2")
    public String demo2(){
        return "Next-Method!";
    }

    @PostMapping("/demo3")
    public String demo3(){
        return "demo3 POST";
    }
}
