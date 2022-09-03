package com.mifort.hr.automation.microservices.userservice.request;

import com.mifort.hr.automation.microservices.userservice.data.CandidateStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateNewCandidate {
    @NotBlank
    @Size(min = 2)
    private String id;
    private String status;
}
