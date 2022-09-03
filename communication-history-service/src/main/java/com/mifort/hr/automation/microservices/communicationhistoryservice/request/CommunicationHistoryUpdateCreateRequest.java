package com.mifort.hr.automation.microservices.communicationhistoryservice.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CommunicationHistoryUpdateCreateRequest {
    @NotBlank
    @Size(min = 2)
    private String comment;
}
