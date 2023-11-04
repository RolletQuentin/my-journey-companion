package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.Mark;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.service.MarkService;
import com.lesvp.myJourneyCompanion.service.UserService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class VideoGameController {

    @Autowired
    private MarkService markService;
    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private UserService userService;

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

    @PostMapping("/createMark")
    public String CreateMark(@RequestParam String uuidVideoGame, String uuidAuthor, double givenMark) {

        try {
            Mark newMark = markService.createMark(givenMark, UUID.fromString(uuidVideoGame), UUID.fromString(uuidAuthor));
            double average = markService.averageMark(UUID.fromString(uuidVideoGame));
            videoGameService.update(UUID.fromString(uuidVideoGame), (int) average);

        } catch (Throwable e) {
            return "error";
        }

        return "redirect:/games?uuid="+uuidVideoGame;
    }


}
