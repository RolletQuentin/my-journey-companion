package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class QuizController {


    @Autowired
    private QuizService quizService;
    @Autowired
    private VideoGameService videoGameService;
    @GetMapping("/createQuiz")
    public String showCreateQuiz(@RequestParam String uuid, Model model) {
        try {
            VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuid));
            model.addAttribute("game", videoGameData);
        } catch (Throwable e) {
            return "error";
        }

        return "createQuiz";
    }

    @GetMapping("/answerQuiz")
    public String showAnswerQuiz(@RequestParam String uuid, Model model) {
        try {
            VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuid));
            model.addAttribute("game", videoGameData);
        } catch (Throwable e) {
            return "error";
        }

        return "answerQuiz";
    }

}
