package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.*;
import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.UserService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
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

    @PostMapping("/createQuiz")
    public String createQuiz(Model model) {
        return "redirect:/";
    }

    @GetMapping("/answerQuiz")
    public String showAnswerQuiz(@RequestParam String uuidGame, Model model) {
        try {
            Quiz quiz = quizService.getQuiz(UUID.fromString(uuidGame));
            model.addAttribute("quiz", quiz);
        } catch (Throwable e) {
            return "error";
        }
        return "answerQuiz";
    }
/*
    @PostMapping("/create")
    public String createQuiz(String quizTitle, List<Question> questions, List<List<Answer>> answers, String authorUuid) {
        if (quizTitle == null || questions == null || answers == null) {
            return "Les données sont invalides";
        }

        Quiz quiz = new Quiz(
                quizTitle,
                questions,
                author,
        );

        userService.createUser(user);

        return "redirect:/login";
    }

 */

}
