package com.lesvp.myJourneyCompanion;

import com.lesvp.myJourneyCompanion.model.Role;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import com.lesvp.myJourneyCompanion.security.TokenManager;
import com.lesvp.myJourneyCompanion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyJourneyCompanionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJourneyCompanionApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	// to fill the database at the start of the application
	@Bean
	public CommandLineRunner runner() {
		return args -> {

			User admin = new User(
					"admin",
					"admin@admin.com",
					UserService.hashPassword("admin"),
					new ArrayList<>(List.of(Role.USER, Role.ADMIN))
			);
			userRepository.save(admin);

			User user = new User(
					"user",
					"user@user.com",
					UserService.hashPassword("user"),
					new ArrayList<>(List.of(Role.USER))
			);
			userRepository.save(user);

			TokenManager tokenManager = TokenManager.getInstance();
		};
	}
}
