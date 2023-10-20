package com.lesvp.myJourneyCompanion.controller;

import com.lesvp.myJourneyCompanion.model.user.Role;
import com.lesvp.myJourneyCompanion.model.user.User;
import com.lesvp.myJourneyCompanion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String allUsers(Model model) {

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/{uuid}")
    public String getUserByUuid(@PathVariable UUID uuid, Model model) {
        User user = userService.getUser(uuid);

        if (user != null) {
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "user-not-found";
        }
    }

    @PostMapping("/create")
    public String createUser(String username, String email, String password) {
        if (username == null || email == null || password == null) {
            return "Les données sont invalides";
        }

        String hashedPassword = UserService.hashPassword(password);

        User user = new User(
                username,
                email,
                hashedPassword,
                new ArrayList<>(List.of(Role.USER))
        );

        userService.createUser(user);

        return "redirect:/create";
    }

    @PutMapping("/update")
    public String updateUser(UUID uuid, String username, String email) {
        if (username == null || email == null || uuid == null) {
            return "Les données sont invalides";
        }


    }
}
