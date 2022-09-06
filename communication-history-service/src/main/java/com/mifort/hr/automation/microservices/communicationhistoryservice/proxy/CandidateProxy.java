package com.mifort.hr.automation.microservices.communicationhistoryservice.proxy;

import com.mifort.hr.automation.microservices.communicationhistoryservice.response.CandidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidate-service", url = "${CANDIDATE_SERVICE_HOST:http://localhost}:8000/api/v1/candidate")
public interface CandidateProxy {
    @GetMapping("/{candidateId}")
    CandidateResponse getById(@PathVariable String candidateId);
}
