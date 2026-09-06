package com.financeops.agent.report;

import com.financeops.agent.util.StringX;

import java.util.List;
import java.util.Objects;

public record DiagnosisReport(DiagnosticCategory category,
                              Severity severity,
                              String summary,
                              List<String> evidence,
                              List<String> possibleCauses,
                              List<String> actions,
                              List<String> risks,
                              List<String> verification,
                              boolean insufficientEvidence) {

    public DiagnosisReport{
        Objects.requireNonNull(category,"category must not be null");
        Objects.requireNonNull(severity,"severity must not be null");
        if(StringX.isEmpty(summary))
            throw new IllegalArgumentException("summary must not be empty");
        summary = summary.strip();
        evidence = List.copyOf(Objects.requireNonNull(evidence));
        possibleCauses = List.copyOf(Objects.requireNonNull(possibleCauses));
        actions = List.copyOf(Objects.requireNonNull(actions));
        risks = List.copyOf(Objects.requireNonNull(risks));
        verification = List.copyOf(Objects.requireNonNull(verification));
    }

}
