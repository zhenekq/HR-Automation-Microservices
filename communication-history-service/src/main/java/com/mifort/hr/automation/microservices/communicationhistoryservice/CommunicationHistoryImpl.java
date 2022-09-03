package com.mifort.hr.automation.microservices.communicationhistoryservice;

import com.mifort.hr.automation.microservices.communicationhistoryservice.data.CommunicationHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommunicationHistoryImpl implements CommunicationHistoryService{

    private final CommunicationHistoryRepository communicationHistoryRepository;

    @Override
    public List<CommunicationHistory> getByUserId(String userId) {
        return communicationHistoryRepository.findAllByUserId(userId);
    }

    @Override
    public void createByUserId(CommunicationHistory communicationHistory, String userId) {
        communicationHistory.setUserId(userId);
        communicationHistory.setCreateDate(LocalDateTime.now());
        communicationHistory.setUpdateDate(LocalDateTime.now());
        communicationHistoryRepository.save(communicationHistory);
    }

    @Override
    public void updateByUserId(String userId, CommunicationHistory communicationHistory, Long historyId) {
    }
}
