package com.mifort.hr.automation.microservices.userservice.converter;

import com.mifort.hr.automation.microservices.userservice.data.CandidateStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CandidateStatusConverter implements AttributeConverter<CandidateStatus, String> {
    @Override
    public String convertToDatabaseColumn(CandidateStatus candidateStatus) {
        if(candidateStatus == null){
            return CandidateStatus.CREATED.toString();
        }
        return candidateStatus.toString();
    }

    @Override
    public CandidateStatus convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
        try {
            return CandidateStatus.valueOf(s);
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
