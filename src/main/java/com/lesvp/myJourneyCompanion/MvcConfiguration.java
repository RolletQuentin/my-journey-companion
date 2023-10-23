package com.lesvp.myJourneyCompanion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/games").setViewName("games");
        registry.addViewController("/createQuiz").setViewName("createQuiz");
        registry.addViewController("/game-details").setViewName("gameDetails");
        registry.addViewController("/topten").setViewName("topten");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/admin").setViewName("admin");
    }
}
