package com.mifort.hr.automation.microservices.userservice;

import com.mifort.hr.automation.microservices.userservice.data.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {
}
