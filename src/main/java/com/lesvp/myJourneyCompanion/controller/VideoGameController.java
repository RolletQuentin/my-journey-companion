package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/games/all")
    public String showVideoGames(Model model) {
        try {
            List<VideoGame> videoGamesData = videoGameService.getVideoGames();
            model.addAttribute("games", videoGamesData);
        } catch (Throwable e) {
            return "error";
        }

        return "games";
    }

    @GetMapping("/")
    public String showVideoGamesHome(Model model) {
        try {
            List<VideoGame> videoGamesData = videoGameService.getVideoGames();
            model.addAttribute("games", videoGamesData);
        } catch (Throwable e) {
            return "error";
        }

        return "home";
    }

    @GetMapping("/games")
    public String showVideoGameDetails(@RequestParam String uuid, Model model) {
        try {
            VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuid));
            model.addAttribute("game", videoGameData);
        } catch (Throwable e) {
            return "error";
        }

        return "gameDetails";
    }

    @GetMapping("/games/topten")
    public String showTopTen(Model model) {
        try {
            List<VideoGame> videoGamesData = videoGameService.getTopTen();
            model.addAttribute("games", videoGamesData);
        } catch (Throwable e) {
            return "error";
        }

        return "topten";
    }
}
