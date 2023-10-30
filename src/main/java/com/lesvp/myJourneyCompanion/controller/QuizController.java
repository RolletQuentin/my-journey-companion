package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.*;
import com.lesvp.myJourneyCompanion.security.CustomUserDetails;
import com.lesvp.myJourneyCompanion.service.AnswerService;
import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.UserService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class QuizController {


    @Autowired
    private QuizService quizService;
    @Autowired
    private VideoGameService videoGameService;
    @Autowired
    private UserService userService;
    @Autowired
    private AnswerService answerService;

    @GetMapping("/createQuiz")
    public String showCreateQuiz(@RequestParam String uuid, Model model, Authentication authentication) {

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            UUID userUuid = userDetails.getUserUUID();

            try {
                VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuid));
                model.addAttribute("game", videoGameData);

                User user = userService.getUser(userUuid);
                model.addAttribute("user", user);

            } catch (Throwable e) {
                return "error";
            }
        }

        return "createQuiz";
    }

    @PostMapping("/createQuiz")
    public String createQuiz(@RequestParam String jsonQuiz, @RequestParam String userUuid, @RequestParam String gameUuid) {
        quizService.createQuiz(jsonQuiz, userUuid, gameUuid);
        return "redirect:/games?uuid=" + gameUuid;
    }

    @GetMapping("/answerQuiz")
    public String showAnswerQuiz(@RequestParam String uuid, Model model) {
        try {
            Quiz quiz = quizService.getQuiz(UUID.fromString(uuid));
            model.addAttribute("quiz", quiz);
        } catch (Throwable e) {
            return "error";
        }
        return "answerQuiz";
    }

//    @PostMapping("/submitAnswers")
//    public String submitAnswers(@RequestParam Map<String, String> formParams) {
//        int totalPoints = 0;
//
//        // Parcourez les paramètres du formulaire
//        for (Map.Entry<String, String> entry : formParams.entrySet()) {
//            String paramName = entry.getKey();
//            String paramValue = entry.getValue();
//
//            // Vérifiez si la réponse est correcte
//            Answer answer = answerService.getAnswer(UUID.fromString(paramValue));
//            if (answer != null && answer.isCorrect()) {
//                // Ajoutez les points en fonction de la question
//                String[] paramParts = paramName.split("-");
//                if (paramParts.length == 3) {
//                    int questionNumber = Integer.parseInt(paramParts[1]);
//                    totalPoints += 1.0 / questionNumber;
//                }
//            }
//        }
//        // Utilisez totalPoints comme bon vous semble...
//
//        // Redirigez vers une page de confirmation ou une autre action après la soumission
//        return "quizResult";
//    }

}
