package com.lesvp.myJourneyCompanion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private Quiz quiz;

    public Question() {}

    public Question(String questionTitle, Quiz quiz) {
        this.questionTitle = questionTitle;
        this.quiz = quiz;
    }
}