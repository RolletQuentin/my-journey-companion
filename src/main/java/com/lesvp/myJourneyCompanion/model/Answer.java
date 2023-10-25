package com.lesvp.myJourneyCompanion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String answerTitle;

    @ManyToOne
    @JoinColumn(name = "question", referencedColumnName = "uuid")
    private Question question;
}
