package com.jvatechs.mygame.servlets.model;

import com.jvatechs.mygame.servlets.model.basic_entities.Answer;
import com.jvatechs.mygame.servlets.model.basic_entities.Conditions;
import com.jvatechs.mygame.servlets.model.basic_entities.Question;
import com.jvatechs.mygame.servlets.model.basic_entities.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class InitClass {
    private final List<Question> questionList;
    private final List<Answer> yesAnswers;
    private final List<Answer> noAnswers;
    private final HashMap<Conditions, List<Result>> resultMap;

    public InitClass() {
        //create
        this.questionList = createQuestionsList();
        this.resultMap = createResults();
        this.yesAnswers = createYesAnswers();
        this.noAnswers = createNoAnswers();

        //set
        setYesAnswers();
        setNoAnswers();
        setQuestionList();
    }


    private List<Question> createQuestionsList() {
        String que1 = """
                Ты потерял память.
                Принять вызов НЛО?
                """;
        String que2 = """
                Ты принял вызов.
                Поднимаешься на мостик к капитану?
                """;
        String que3 = """
                Ты поднялся на мостик.
                Ты кто?
                """;

        Question question1 = new Question(que1);
        Question question2 = new Question(que2);
        Question question3 = new Question(que3);

        return List.of(question1, question2, question3);
    }

    private HashMap<Conditions, List<Result>> createResults() {
        Result gameOverResult1 = new Result("Ты отклонил вызов. Поражение\n", Conditions.GAME_OVER, 1);
        Result gameOverResult2 = new Result("Ты не пошел на переговоры. Поражение\n", Conditions.GAME_OVER, 2);
        Result gameOverResult3 = new Result("Твою ложь разоблачили. Поражение\n", Conditions.GAME_OVER, 3);
        Result winResult3 = new Result("Тебя вернули домой. Победа\n", Conditions.WIN, 3);

        HashMap<Conditions, List<Result>> map = new HashMap<>();
        map.put(Conditions.GAME_OVER, List.of(gameOverResult1, gameOverResult2, gameOverResult3));
        map.put(Conditions.WIN, List.of(winResult3));
        return map;
    }
    private List<Answer> createYesAnswers() {

        Answer yesAnswer1 = new Answer("Принять вызов\n", 1);
        Answer yesAnswer2 = new Answer("Подняться на мостик\n", 2);
        Answer yesAnswer3 = new Answer("Рассказать правду о себе\n", 3);

        yesAnswer1.setQuestionOrResult(questionList.get(1));
        yesAnswer2.setQuestionOrResult(questionList.get(2));
        yesAnswer3.setQuestionOrResult(resultMap.get(Conditions.WIN).get(0));

        return List.of(yesAnswer1, yesAnswer2, yesAnswer3);
    }

    private void setYesAnswers() {
        for (int i = 0; i < yesAnswers.size(); i++) {
            if (i == yesAnswers.size() - 1) {
                yesAnswers.get(i).setQuestionOrResult(resultMap.get(Conditions.WIN).get(0));
            } else {
                yesAnswers.get(i).setQuestionOrResult(questionList.get(i + 1));
            }
        }
    }

    private List<Answer> createNoAnswers() {
        Answer noAnswer1 = new Answer("Отклонить вызов\n", 1);
        Answer noAnswer2 = new Answer("Отказаться подниматься на мостик\n", 2);
        Answer noAnswer3 = new Answer("Солгать о себе\n", 3);

        return List.of(noAnswer1, noAnswer2, noAnswer3);
    }

    private void setNoAnswers() {
        for (int i = 0; i < noAnswers.size(); i++) {
            noAnswers.get(i).setQuestionOrResult(resultMap.get(Conditions.GAME_OVER).get(i));
        }
    }

    private void setQuestionList() {
        for (int i = 0; i < questionList.size(); i++) {
            questionList.get(i).setYesAnswer(yesAnswers.get(i));
            questionList.get(i).setNoAnswer(noAnswers.get(i));
            questionList.get(i).setId(i + 1);
        }
    }


}
