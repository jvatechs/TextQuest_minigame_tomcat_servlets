package com.jvatechs.mygame.servlets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuestionTest {

    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question();
    }

    @Test
    void testQuestionText() {
        question.setQuestionText("Test Question Text");
        assertEquals("Test Question Text", question.getQuestionText());
    }

    @Test
    void testYesAnswer() {
        Answer yesAnswer = new Answer();
        question.setYesAnswer(yesAnswer);
        assertEquals(yesAnswer, question.getYesAnswer());
    }

    @Test
    void testNoAnswer() {
        Answer noAnswer = new Answer();
        question.setNoAnswer(noAnswer);
        assertEquals(noAnswer, question.getNoAnswer());
    }

    @Test
    void testId() {
        int id = 42;
        question.setId(id);
        assertEquals(42, question.getId());
    }

    @Test
    void testParameterizedConstructor() {
        Question parameterizedQuestion = new Question("Parameterized Question");
        assertEquals("Parameterized Question", parameterizedQuestion.getQuestionText());
    }

    @Test
    void testToString() {
        question.setQuestionText("Test Question Text");
        assertEquals("Question{questionText='Test Question Text'}", question.toString());
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(question);
    }

    @Test
    void testAllArgsConstructor() {
        Question allArgsConstructorQuestion = new Question("Question Text", new Answer(), new Answer(), 2);
        assertNotNull(allArgsConstructorQuestion);
    }
}