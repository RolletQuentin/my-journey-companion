package com.lesvp.myJourneyCompanion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String questionTitle;

    @OneToMany
    private List<Answer> answers;


    public Question() {}

}