package com.jvatechs.mygame.servlets.model;

import com.jvatechs.mygame.servlets.model.basic_entities.Answer;
import com.jvatechs.mygame.servlets.model.basic_entities.Conditions;
import com.jvatechs.mygame.servlets.model.basic_entities.Question;
import com.jvatechs.mygame.servlets.model.basic_entities.Result;

public class InitClass {
    public void createQuestions() {
        String que1 = "Ты потерял память.\n" +
                "Принять вызов НЛО?\n";

        String que2 = "Ты принял вызов.\n" +
                "Поднимаешься на мостик к капитану?\n";

        String que3 = "Ты поднялся на мостик.\n" +
                "Ты кто?\n";

        Answer yesAnswer1 = new Answer("Принять вызов\n", 1);
        Answer yesAnswer2 = new Answer("Подняться на мостик\n", 2);
        Answer yesAnswer3 = new Answer("Рассказать правду о себе\n", 3);

        Answer noAnswer1 = new Answer("Отклонить вызов\n", 1);
        Answer noAnswer2 = new Answer("Отказаться подниматься на мостик\n", 2);
        Answer noAnswer3 = new Answer("Солгать о себе\n", 3);


        Question question1 = new Question(que1, yesAnswer1, noAnswer1, 1);
        Question question2 = new Question(que2, yesAnswer2, noAnswer2, 2);
        Question question3 = new Question(que3, yesAnswer3, noAnswer3, 3);

        Result gameOverResult1 = new Result("Ты отклонил вызов. Поражение\n", Conditions.GAME_OVER, 1);
        Result gameOverResult2 = new Result("Ты не пошел на переговоры. Поражение\n", Conditions.GAME_OVER, 2);
        Result gameOverResult3 = new Result("Твою ложь разоблачили. Поражение\n", Conditions.GAME_OVER, 3);
        Result winResult3 = new Result("Тебя вернули домой. Победа\n", Conditions.WIN, 3);

        yesAnswer1.setQuestionOrResult(question2);
        yesAnswer2.setQuestionOrResult(question3);
        yesAnswer3.setQuestionOrResult(winResult3);

        noAnswer1.setQuestionOrResult(gameOverResult1);
        noAnswer2.setQuestionOrResult(gameOverResult2);
        noAnswer3.setQuestionOrResult(gameOverResult3);
    }
}
