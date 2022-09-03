package com.mifort.hr.automation.microservices.communicationhistoryservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationHistoryDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String comment;
}
