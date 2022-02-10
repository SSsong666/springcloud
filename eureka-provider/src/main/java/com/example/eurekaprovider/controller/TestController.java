package com.example.eurekaprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getHi")
    public String GetHi(){
        return "Hi Lao Wang";
    }

    @GetMapping("/helloWorld")
    public String GetHelloWorld(){
        return "Hello World";
    }
}
