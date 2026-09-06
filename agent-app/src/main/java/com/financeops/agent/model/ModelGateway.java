package com.financeops.agent.model;

import com.financeops.agent.report.DiagnosisReport;
import com.financeops.agent.report.DiagnosisRequest;

public interface ModelGateway {
    DiagnosisReport diagnose(DiagnosisRequest request);
}
