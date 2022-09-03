package com.mifort.hr.automation.microservices.communicationhistoryservice;

import com.mifort.hr.automation.microservices.communicationhistoryservice.data.CommunicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationHistoryRepository extends JpaRepository<CommunicationHistory, Long> {
    List<CommunicationHistory> findAllByUserId(String userId);
}
