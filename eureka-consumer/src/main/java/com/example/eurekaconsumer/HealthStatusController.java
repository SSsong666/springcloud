package com.example.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusController {

    @Autowired
    HealthStatusService service;

    @GetMapping("/health/status/{status}")
    public String health(@PathVariable Boolean status) {

        service.setStatus(status);
        return service.getStatus();
    }
}
