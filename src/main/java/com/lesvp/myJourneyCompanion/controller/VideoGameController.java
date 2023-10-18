package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/videoGames")
    public String showVideoGames(Model model) {
        String videoGamesData = null;
        try {
            videoGamesData = videoGameService.getVideoGames();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("videoGames", videoGamesData);

        return "videoGames";
    }
}
