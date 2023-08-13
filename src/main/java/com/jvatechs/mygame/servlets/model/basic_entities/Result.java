package com.jvatechs.mygame.servlets.model.basic_entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Result implements Gradable {
    private String resultText;
    private Conditions conditions;
    private int id;

    @Override
    public String toString() {
        return "Result{" +
                "resultText='" + resultText + '\'' +
                '}';
    }
}
