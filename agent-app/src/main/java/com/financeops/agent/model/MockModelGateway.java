package com.financeops.agent.model;

import com.financeops.agent.report.DiagnosisReport;
import com.financeops.agent.report.DiagnosisRequest;
import com.financeops.agent.report.DiagnosticCategory;
import com.financeops.agent.report.Severity;

import java.util.List;
import java.util.Objects;

public class MockModelGateway implements ModelGateway{
    @Override
    public DiagnosisReport diagnose(DiagnosisRequest request) {
        Objects.requireNonNull(request, "request must not be null");
        return new DiagnosisReport(
                DiagnosticCategory.UNKNOWN,
                Severity.INFO,
                "当前证据不足，无法判断具体根因",
                List.of(),
                List.of(),
                List.of("补充问题发生时间和受影响接口"),
                List.of("证据不足时直接修改系统可能扩大影响"),
                List.of("采集接口耗时、错误日志、CPU和GC指标"),
                true
        );
    }
}
