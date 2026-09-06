package com.financeops.agent.report;

import com.financeops.agent.util.StringX;

public record DiagnosisRequest(String question, String sampleRef) {
    public DiagnosisRequest{
        if(StringX.isEmpty(question)){
            throw new IllegalArgumentException("question must not be blank");
        }
        sampleRef = StringX.isEmpty(sampleRef) ? "" : sampleRef.strip();
    }
}
