package com.financeops.agent.model;

import com.financeops.agent.report.DiagnosisRequest;
import com.financeops.agent.report.DiagnosticCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MockModelGatewayTest {

    @Test
    void shouldReturnInsufficientEvidenceReport() {
        var gateway = new MockModelGateway();
        var request = new DiagnosisRequest("系统很慢", "");

        var report = gateway.diagnose(request);

        assertEquals(DiagnosticCategory.UNKNOWN, report.category());
        assertTrue(report.insufficientEvidence());
        assertTrue(report.evidence().isEmpty());
        assertFalse(report.actions().isEmpty());
        assertFalse(report.verification().isEmpty());
    }
}