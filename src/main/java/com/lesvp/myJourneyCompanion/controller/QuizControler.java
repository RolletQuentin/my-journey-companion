package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class QuizControler {


    @Autowired
    private QuizService quizService;


}
