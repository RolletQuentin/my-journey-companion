package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/video-games")
    public ResponseEntity<String> showVideoGames(Model model) {
        try {
            var videoGamesData = videoGameService.getVideoGames();
            model.addAttribute("videoGames", videoGamesData);
        } catch (Throwable e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }

        return ResponseEntity.ok("videoGames");
    }
}
