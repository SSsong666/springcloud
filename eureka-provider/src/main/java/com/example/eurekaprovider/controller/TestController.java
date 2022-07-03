package com.example.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String GetHi(){
        return "Hi Lao Wang,我的port: "+port;
    }

    @GetMapping("/helloWorld")
    public String GetHelloWorld(){
        return "Hello World";
    }
}
