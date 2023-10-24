package com.lesvp.myJourneyCompanion;

import com.lesvp.myJourneyCompanion.model.Role;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import com.lesvp.myJourneyCompanion.repository.VideoGameRepository;
import com.lesvp.myJourneyCompanion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MyJourneyCompanionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJourneyCompanionApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VideoGameRepository videoGameRepository;

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

			videoGameRepository.save(new VideoGame(
					"Super Mario Galaxy",
					"Super Mario Galaxy is a 2007 platform game developed and published by Nintendo for the Wii. It is the third 3D game in the Super Mario series. As Mario, the player embarks on a quest to rescue Princess Peach, save the universe from Bowser, and collect 120 Power Stars, after which the player can play the game as Luigi for a more difficult experience. The levels consist of galaxies filled with minor planets and worlds, with different variations of gravity, the central element of gameplay. The player character is controlled using the Wii Remote and Nunchuk and completes missions, fights bosses, and reaches certain areas to collect Power Stars. Certain levels use the motion-based Wii Remote functions.",
					100,
					"https://images.igdb.com/igdb/image/upload/t_cover_big/co5wv7.png",
					"Nintendo",
					new Date(2007, 11, 1)
					)
			);

			videoGameRepository.save(new VideoGame(
					"Cyberpunk 2077",
					"Cyberpunk 2077 is a 2020 action role-playing video game developed by CD Projekt Red and published by CD Projekt, based on video game designer Mike Pondsmith's game series. Set in a dystopian Cyberpunk universe, the player assumes the role of \"V\" (played by Gavin Drea/Cherami Leigh), a mercenary in the fictional Californian city known as \"Night City\", where they deal with the fallout from a heist gone wrong that results in an experimental cybernetic \"bio-chip\" containing an engram of the legendary rock star and terrorist Johnny Silverhand (played by Keanu Reeves) threatening to slowly overwrite V's mind; as the story progresses V and Johnny must work together to find a way to be separated and save V's life.",
					95,
					"https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/Cyberpunk_2077_box_art.jpg/220px-Cyberpunk_2077_box_art.jpg",
					"CD Projekt",
					new Date(2020,12,10))
			);

			videoGameRepository.save(new VideoGame(
					"Outer Wilds",
					"Outer Wilds is a 2019 action-adventure game developed by Mobius Digital and published by Annapurna Interactive. It first released for Windows, Xbox One, and PlayStation 4 before releasing for PlayStation 5 and Xbox Series X/S in 2022. The game features the player character exploring a solar system stuck in a 22-minute time loop that ends with the star going supernova.",
					100,
					"https://upload.wikimedia.org/wikipedia/en/thumb/f/f6/Outer_Wilds_Steam_artwork.jpg/220px-Outer_Wilds_Steam_artwork.jpg",
					"Mobius Digital",
					new Date(2019, 5, 28)
			));

			videoGameRepository.save(new VideoGame(
					"Ōkami",
					"Ōkami (Japanese: 大神, lit. \"great god\" or \"great spirit\"; also 狼, \"wolf\")[2] is an action-adventure video game developed by Clover Studio and published by Capcom. It was released for PlayStation 2 in 2006 in Japan and North America, and in 2007 in Europe and Australia. After the closure of Clover Studio a few months after the release, a port for Wii was developed by Ready at Dawn, Tose, and Capcom, and released in 2008.",
					93,
					"https://upload.wikimedia.org/wikipedia/en/thumb/b/be/OkamiNTSCcoverFinal.jpg/220px-OkamiNTSCcoverFinal.jpg",
					"Capcom",
					new Date(2006, 4, 20)
			));

			videoGameRepository.save(new VideoGame(
					"RimWorld",
					"RimWorld is a construction and management simulation video game developed and published by Canadian-based developer Ludeon Studios.[3] Originally called Eclipse Colony, it was initially released as a Kickstarter crowdfunding project in early access for Microsoft Windows, macOS, and Linux in November 2013, and was released on October 17, 2018. The game was released for PlayStation 4 and Xbox One as RimWorld Console Edition on July 29, 2022, with development and publishing being handled by Double Eleven.[4] Rather than a test of skill or a challenge, the game is intended to serve as an AI-powered \"story generator\", where the game is used as the medium for players to experience narrative adventures. The game has received generally positive reviews from critics.",
					96,
					"https://media.senscritique.com/media/000020160553/300/rimworld.jpg",
					"Ludeon Studios",
					new Date(2022, 7, 29)
			));

			videoGameRepository.save(new VideoGame(
					"Microsoft Flight Simulator",
					"Microsoft Flight Simulator is an amateur flight simulator developed by Asobo Studio and published by Xbox Game Studios. It is an entry in the Microsoft Flight Simulator series which began in 1982, and was preceded by Microsoft Flight Simulator X in 2006. The game is a return of the series after 14 years, with development beginning six years prior to its release. It was released on August 18, 2020, for Windows, with a virtual reality (VR) version released in December of the same year as part of the free Sim 2 update. Microsoft Flight Simulator is the first game in the series to see a VR and console release, with it being released on the Xbox Series X and Series S on July 27, 2021.",
					91,
					"https://upload.wikimedia.org/wikipedia/en/thumb/8/84/Microsoft_Flight_Simulator_2020_cover_art.png/220px-Microsoft_Flight_Simulator_2020_cover_art.png",
					"Asobo Studio",
					new Date(2020, 8, 18)
			));

			videoGameRepository.save(new VideoGame(
					"Final Fantasy VII",
					"Final Fantasy VII[a] is a 1997 role-playing video game developed by Square for the PlayStation console and the seventh main installment in the Final Fantasy series. Square published the game in Japan, and it was released in other regions by Sony Computer Entertainment, becoming the first game in the main series to have a PAL release. The game's story follows Cloud Strife, a mercenary who joins an eco-terrorist organization to stop a world-controlling megacorporation from using the planet's life essence as an energy source. Events send Cloud and his allies in pursuit of Sephiroth, a superhuman who seeks to wound the planet and harness its healing power to be reborn as a god. During their journey, Cloud bonds with his party members, including Aerith Gainsborough, who holds the secret to saving their world.",
					90,
					"https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/Final_Fantasy_VII_Box_Art.jpg/220px-Final_Fantasy_VII_Box_Art.jpg",
					"Square",
					new Date(1997, 1, 31)
			));

			videoGameRepository.save(new VideoGame(
					"The Last of Us",
					"The Last of Us is a 2013 action-adventure game developed by Naughty Dog and published by Sony Computer Entertainment. Players control Joel, a smuggler tasked with escorting a teenage girl, Ellie, across a post-apocalyptic United States. The Last of Us is played from a third-person perspective. Players use firearms and improvised weapons and can use stealth to defend against hostile humans and cannibalistic creatures infected by a mutated fungus. In the online multiplayer mode, up to eight players engage in cooperative and competitive gameplay.",
					93,
					"https://upload.wikimedia.org/wikipedia/en/thumb/4/46/Video_Game_Cover_-_The_Last_of_Us.jpg/220px-Video_Game_Cover_-_The_Last_of_Us.jpg",
					"Naughty Dog",
					new Date(2013, 6, 14)
			));

			videoGameRepository.save(new VideoGame(
					"The Elder Scrolls V : Skyrim",
					"The Elder Scrolls V: Skyrim is an action role-playing video game developed by Bethesda Game Studios and published by Bethesda Softworks. It is the fifth main installment in The Elder Scrolls series, following The Elder Scrolls IV: Oblivion (2006), and was released worldwide for Microsoft Windows, PlayStation 3, and Xbox 360 on November 11, 2011.",
					93,
					"https://upload.wikimedia.org/wikipedia/en/thumb/1/15/The_Elder_Scrolls_V_Skyrim_cover.png/220px-The_Elder_Scrolls_V_Skyrim_cover.png",
					"Bethesda Game Studios",
					new Date(2011, 11, 11)
			));

			videoGameRepository.save(new VideoGame(
					"The Legend of Zelda : Breath of the Wild",
					"The Legend of Zelda: Breath of the Wild is a 2017 action-adventure game developed and published by Nintendo for the Nintendo Switch and Wii U. Set at the end of the Zelda timeline, the player controls an amnesiac Link as he sets out to save Princess Zelda and prevent Calamity Ganon from destroying the world. Players explore the open world of Hyrule while they collect items and complete objectives such as puzzles or side quests. Breath of the Wild's world is unstructured and encourages exploration and experimentation; the story can be completed in a nonlinear fashion.",
					105,
					"https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/The_Legend_of_Zelda_Breath_of_the_Wild.jpg/220px-The_Legend_of_Zelda_Breath_of_the_Wild.jpg",
					"Nintendo",
					new Date(2017, 3, 3)
			));

			videoGameRepository.save(new VideoGame(
					"FlatOut 2",
					"FlatOut 2 is a 2006 action racing video game developed by Bugbear Entertainment and published by Empire Interactive in Europe and Vivendi Universal Games in North America. It is the sequel to the 2004 game FlatOut.",
					94,
					"https://upload.wikimedia.org/wikipedia/en/thumb/4/40/Flatout2pc.jpg/220px-Flatout2pc.jpg",
					"Bugbear Entertainment",
					new Date(2006, 6, 30)
			));

			videoGameRepository.save(new VideoGame(
					"Frostpunk",
					"Frostpunk is a city-building survival game developed and published by 11 bit studios. Players take on the role of a leader in an alternate history late 19th century, in which they must build and maintain a city during a worldwide volcanic winter, managing resources, making choices on how to survive, and exploring the area outside their city for survivors, resources, or other useful items. The game features several scenarios to undertake, each with their own stories and different challenges.",
					84,
					"https://upload.wikimedia.org/wikipedia/en/thumb/a/a3/Frostpunk_cover_art.jpg/220px-Frostpunk_cover_art.jpg",
					"11 bit studios",
					new Date(2019, 10, 11)
			));
		};
	}
}
