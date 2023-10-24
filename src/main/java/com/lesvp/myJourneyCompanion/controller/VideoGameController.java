package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/games")
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/all")
    public String showVideoGames(Model model) {
        try {
            List<VideoGame> videoGamesData = videoGameService.getVideoGames();
            model.addAttribute("games", videoGamesData);
        } catch (Throwable e) {
            return "error";
        }

        return "games";
    }
}
