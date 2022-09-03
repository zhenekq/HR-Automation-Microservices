package com.mifort.hr.automation.microservices.userservice.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CandidateDto {
    private String id;
    private LocalDateTime lastContact;
    private String status;
}

