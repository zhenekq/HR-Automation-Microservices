package com.mifort.hr.automation.microservices.userservice;

import com.mifort.hr.automation.microservices.userservice.data.Candidate;
import com.mifort.hr.automation.microservices.userservice.data.CandidateDto;
import com.mifort.hr.automation.microservices.userservice.request.CreateNewCandidate;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    private final CandidateService candidateService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CandidateDto> getAll(){
        List<Candidate> candidates = candidateService.getAll();
        return candidates
                .stream()
                .map(candidate -> modelMapper.map(candidate, CandidateDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{candidateId}")
    public CandidateDto getById(@PathVariable String candidateId){
        Candidate candidate = candidateService.getById(candidateId);
        return modelMapper.map(candidate, CandidateDto.class);
    }

    @PostMapping
    public ResponseEntity<Candidate> create(@Valid @RequestBody CreateNewCandidate createNewCandidate){
        Candidate candidate = modelMapper.map(createNewCandidate, Candidate.class);
        return new ResponseEntity<Candidate>(candidateService.create(candidate), HttpStatus.CREATED);
    }

}
