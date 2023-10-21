package com.lesvp.myJourneyCompanion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String questionTitle;

    private String uuidGame;

    private String uuidAuthor;

    public Question() {}

    public Question(String quizTitle) {
        this.questionTitle = quizTitle;
    }
}