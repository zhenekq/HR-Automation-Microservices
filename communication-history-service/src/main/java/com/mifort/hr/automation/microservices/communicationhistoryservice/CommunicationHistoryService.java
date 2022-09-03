package com.mifort.hr.automation.microservices.communicationhistoryservice;

import com.mifort.hr.automation.microservices.communicationhistoryservice.data.CommunicationHistory;

import java.util.List;

public interface CommunicationHistoryService {

    List<CommunicationHistory> getByUserId(String userId);
    void createByUserId(CommunicationHistory communicationHistory, String userId);
    void updateByUserId(String userId, CommunicationHistory communicationHistory, Long historyId);
}
