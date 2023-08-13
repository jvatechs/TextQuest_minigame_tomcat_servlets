package com.jvatechs.mygame.servlets.model.basic_entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Question implements Gradable {
    private String questionText;
    private Answer yesAnswer;
    private Answer noAnswer;
    private int id;

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                '}';
    }
}
