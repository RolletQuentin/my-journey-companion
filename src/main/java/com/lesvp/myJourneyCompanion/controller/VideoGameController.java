package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.Quiz;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.security.CustomUserDetails;
import com.lesvp.myJourneyCompanion.service.QuizService;
import com.lesvp.myJourneyCompanion.service.UserService;
import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;
    @Autowired
    private QuizService quizService;
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
    public String showVideoGameDetails(@RequestParam String uuid, Model model, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            User user = userService.getUser(customUserDetails.getUserUUID());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", null);
        }

        try {
            VideoGame videoGameData = videoGameService.getVideoGame(UUID.fromString(uuid));
            model.addAttribute("game", videoGameData);
            List<Quiz> quiz = quizService.getQuizByVideoGame(videoGameData);
            model.addAttribute("quiz", quiz);
        } catch (Throwable e) {
            return "error";
        }

        return "gameDetails";
    }

    @PostMapping("/games/todolist")
    public String addGameToToDoList(@RequestParam String userUUID, @RequestParam String videoGameUUID) {
        User user = userService.getUser(UUID.fromString(userUUID));
        VideoGame videoGame = videoGameService.getVideoGame(UUID.fromString(videoGameUUID));

        userService.addToToDoList(user, videoGame);
        return "redirect:/games?uuid=" + videoGameUUID;
    }

    @PostMapping("/games/donelist")
    public String addGameToDoneList(@RequestParam String userUUID, @RequestParam String videoGameUUID) {
        User user = userService.getUser(UUID.fromString(userUUID));
        VideoGame videoGame = videoGameService.getVideoGame(UUID.fromString(videoGameUUID));

        userService.addToDoneList(user, videoGame);
        return "redirect:/games?uuid=" + videoGameUUID;
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
