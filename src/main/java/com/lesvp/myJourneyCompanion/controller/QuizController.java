package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuizController {


    @Autowired
    private QuizService quizService;


}
