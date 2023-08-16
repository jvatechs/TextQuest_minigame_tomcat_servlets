package com.jvatechs.mygame.servlets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    void testResultText() {
        result.setResultText("Test Result Text");
        assertEquals("Test Result Text", result.getResultText());
    }

    @Test
    void testConditions() {
        result.setConditions(Conditions.GAME_OVER);
        assertEquals(Conditions.GAME_OVER, result.getConditions());
    }

    @Test
    void testId() {
        result.setId(42);
        assertEquals(42, result.getId());
    }

    @Test
    void testToString() {
        result.setResultText("Test Result Text");
        assertEquals("Result{resultText='Test Result Text'}", result.toString());
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(result);
    }

    @Test
    void testAllArgsConstructor() {
        Result allArgsConstructorResult = new Result("Result Text", Conditions.WIN, 3);
        assertNotNull(allArgsConstructorResult);
    }
}
