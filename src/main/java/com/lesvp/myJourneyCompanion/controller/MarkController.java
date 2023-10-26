package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.service.MarkService;
import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.UserService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class MarkController {


    @Autowired
    private MarkService markService;
    @Autowired
    private VideoGameService videoGameService;
    @Autowired
    private UserService userService;
    @PostMapping("/createMark")
    public String showCreateMark(@RequestParam String uuidVideoGame, String uuidAuthor, double givenMark, Model model) {

        try {
            VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuidVideoGame));
            User user = userService.getUser(UUID.fromString(uuidAuthor));

            model.addAttribute("game", videoGameData);
        } catch (Throwable e) {
            return "error";
        }

        return "createMark";
    }
}
