package com.mifort.hr.automation.microservices.userservice;

import com.mifort.hr.automation.microservices.userservice.data.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getAll();

    Candidate getById(String candidateId);

    Candidate create(Candidate candidate);
}
