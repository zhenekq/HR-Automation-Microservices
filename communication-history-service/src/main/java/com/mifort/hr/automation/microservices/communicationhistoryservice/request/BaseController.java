package com.mifort.hr.automation.microservices.communicationhistoryservice.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping
    public String testCD(){
        return "LAST CHANCE";
    }
}
