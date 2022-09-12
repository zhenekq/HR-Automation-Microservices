package com.mifort.hr.automation.microservices.userservice.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping
    public String kubernetesWorks(){
        return "MAX SURGE EQUALS TO ZERO";
    }
}
