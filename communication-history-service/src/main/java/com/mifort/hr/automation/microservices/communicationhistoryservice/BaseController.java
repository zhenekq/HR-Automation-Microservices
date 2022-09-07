package com.mifort.hr.automation.microservices.communicationhistoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping
    public String test(){
        return "HISTORY CI";
    }

}
