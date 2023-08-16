package com.jvatechs.mygame.servlets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnswerTest {

    private Answer answer;

    @BeforeEach
    void setUp() {
        answer = new Answer();
    }

    @Test
    void testAnswerText() {
        answer.setAnswerText("Test Answer Text");
        assertEquals("Test Answer Text", answer.getAnswerText());
    }

    @Test
    void testQuestionOrResult() {
        Gradable gradable = new Gradable() {
            // Implement required methods here (if applicable)
        };
        answer.setQuestionOrResult(gradable);
        assertEquals(gradable, answer.getQuestionOrResult());
    }

    @Test
    void testId() {
        answer.setId(42);
        assertEquals(42, answer.getId());
    }

    @Test
    void testParameterizedConstructor() {
        Answer parameterizedAnswer = new Answer("Parameterized Answer", 1);
        assertEquals("Parameterized Answer", parameterizedAnswer.getAnswerText());
        assertEquals(1, parameterizedAnswer.getId());
    }

    @Test
    void testToString() {
        answer.setAnswerText("Test Answer Text");
        assertEquals("Answer{answerText='Test Answer Text'}", answer.toString());
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(answer);
    }

    @Test
    void testAllArgsConstructor() {
        Answer allArgsConstructorAnswer = new Answer("Answer Text", new Gradable() {
            // Implement required methods here (if applicable)
        }, 2);
        assertNotNull(allArgsConstructorAnswer);
    }
}
