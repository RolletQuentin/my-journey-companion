package com.lesvp.myJourneyCompanion.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String quizTitle;

    private String uuidGame;

    private String uuidAuthor;

    public Quiz() {}

    public Quiz(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
