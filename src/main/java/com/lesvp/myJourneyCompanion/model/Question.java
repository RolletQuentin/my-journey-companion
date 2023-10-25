package com.lesvp.myJourneyCompanion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String questionTitle;


    @ManyToOne
    @JoinColumn(name = "quiz", referencedColumnName = "uuidQuiz")
    private Quiz quiz;

    public Question() {}

    public Question(String questionTitle, Quiz quiz) {
        this.questionTitle = questionTitle;
        this.quiz = quiz;
    }
}