package com.financeops.agent.report;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiagnosisRequestTest {

    @Test
    void shouldRejectBlankQuestion() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new DiagnosisRequest("  ", null)
        );

        assertEquals("question must not be blank", exception.getMessage());
    }
}