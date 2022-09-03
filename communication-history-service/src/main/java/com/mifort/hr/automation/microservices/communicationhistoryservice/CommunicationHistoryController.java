package com.mifort.hr.automation.microservices.communicationhistoryservice;

import com.mifort.hr.automation.microservices.communicationhistoryservice.data.CommunicationHistory;
import com.mifort.hr.automation.microservices.communicationhistoryservice.data.CommunicationHistoryDto;
import com.mifort.hr.automation.microservices.communicationhistoryservice.proxy.CandidateProxy;
import com.mifort.hr.automation.microservices.communicationhistoryservice.request.CommunicationHistoryUpdateCreateRequest;
import com.mifort.hr.automation.microservices.communicationhistoryservice.response.CandidateResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/candidate/{userId}/history")
@AllArgsConstructor
public class CommunicationHistoryController {

    private final CommunicationHistoryService historyService;
    private final CandidateProxy candidateProxy;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CommunicationHistoryDto> getByCandidateId(@PathVariable String userId){
        CandidateResponse user = candidateProxy.getById(userId);
        List<CommunicationHistory> histories = historyService.getByUserId(userId);
        return histories
                .stream()
                .map(history -> modelMapper.map(history, CommunicationHistoryDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createByUserId(@PathVariable String userId,
                               @Valid @RequestBody CommunicationHistoryUpdateCreateRequest newCommunicationHistory){
        CandidateResponse user = candidateProxy.getById(userId);
        if(user.getId() != null){
            CommunicationHistory communicationHistory = modelMapper.map(newCommunicationHistory, CommunicationHistory.class);
            historyService.createByUserId(communicationHistory, userId);
        }
    }

    @PutMapping("/{historyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateByUserId(@PathVariable String userId,
                               @RequestBody CommunicationHistoryUpdateCreateRequest updateHistoryRequest,
                               @PathVariable Long historyId){
        CommunicationHistory communicationHistory = modelMapper.map(updateHistoryRequest, CommunicationHistory.class);
    }
}
