package com.jvatechs.mygame.servlets.model.basic_entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Answer {
    private String answerText;
    private Gradable questionOrResult;
    private int id;

    public Answer(String answerText, int id) {
        this.answerText = answerText;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerText='" + answerText + '\'' +
                '}';
    }
}
