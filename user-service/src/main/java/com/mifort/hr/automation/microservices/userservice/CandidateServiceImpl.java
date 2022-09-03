package com.mifort.hr.automation.microservices.userservice;

import com.mifort.hr.automation.microservices.userservice.data.Candidate;
import com.mifort.hr.automation.microservices.userservice.data.CandidateStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService{

    private final CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getById(String candidateId) {
        return candidateRepository
                .findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException("Candidate with id: " + candidateId + " not exists!"));
    }

    @Override
    public Candidate create(Candidate candidate) {
        if(candidate.getStatus() == null){
            candidate.setStatus(CandidateStatus.CREATED.toString());
        }
        candidate.setLastContact(LocalDateTime.now());
        return candidateRepository.save(candidate);
    }
}
