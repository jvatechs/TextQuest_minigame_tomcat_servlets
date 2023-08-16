package com.jvatechs.mygame.servlets.controller;

import com.jvatechs.mygame.servlets.model.Answer;
import com.jvatechs.mygame.servlets.model.Conditions;
import com.jvatechs.mygame.servlets.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InitClassTest {
    private InitClass initClass;

    @BeforeEach
    void setUp() {
        initClass = new InitClass();
    }

    @Test
    void testInitClassCreation_IsNotNull() {
        assertNotNull(initClass.getQuestionList());
        assertNotNull(initClass.getYesAnswers());
        assertNotNull(initClass.getNoAnswers());
        assertNotNull(initClass.getResultMap());
    }

    @Test
    void testQuestionListCreation_isEqualExpected() {
        assertEquals(3, initClass.getQuestionList().size());
    }

    @Test
    void testCreateResultsMap_IsEqualExpected() {
        assertEquals(2, initClass.getResultMap().size());
    }

    @Test
    void testcreateYesAnswers_IsEqualExpected() {
        assertEquals(3, initClass.getYesAnswers().size());
    }

    @Test
    void testSettingYesAnswers_IsLastAnswersGradable_WinResult() {
        List<Answer> yesAnswers = initClass.getYesAnswers();
        Result winResult = (Result) yesAnswers.get(yesAnswers.size() - 1).getQuestionOrResult();
        assertEquals(Conditions.WIN, winResult.getConditions());
    }


    @Test
    void testCreateNoAnswers_IsEqualExpected() {
        assertEquals(3, initClass.getNoAnswers().size());
    }

    @Test
    void testSetNoAnswers_IsAnyAnswerResult_GameOverCondition() {
        Random random = new Random();
        List<Answer> noAnswers = initClass.getNoAnswers();
        int randomIndexFrom_0_TO_3 = random.nextInt(0, 3);
        Result gameOver = (Result) noAnswers.get(randomIndexFrom_0_TO_3).getQuestionOrResult();

        assertEquals(Conditions.GAME_OVER, gameOver.getConditions());
    }
}