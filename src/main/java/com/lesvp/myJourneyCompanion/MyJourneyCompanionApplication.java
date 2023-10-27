package com.lesvp.myJourneyCompanion;

import com.lesvp.myJourneyCompanion.model.*;
import com.lesvp.myJourneyCompanion.repository.*;
import com.lesvp.myJourneyCompanion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class MyJourneyCompanionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJourneyCompanionApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VideoGameRepository videoGameRepository;

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionRepository questionRepository;

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

//			videoGameRepository.save(new VideoGame(
//					"Super Mario Galaxy",
//					"Super Mario Galaxy is a 2007 platform game developed and published by Nintendo for the Wii. It is the third 3D game in the Super Mario series. As Mario, the player embarks on a quest to rescue Princess Peach, save the universe from Bowser, and collect 120 Power Stars, after which the player can play the game as Luigi for a more difficult experience. The levels consist of galaxies filled with minor planets and worlds, with different variations of gravity, the central element of gameplay. The player character is controlled using the Wii Remote and Nunchuk and completes missions, fights bosses, and reaches certain areas to collect Power Stars. Certain levels use the motion-based Wii Remote functions.",
//					100,
//					"https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/wii_24/SI_Wii_SuperMarioGalaxy_image1600w.jpg",
//					"Nintendo",
//					new Date(2007, 11, 1)
//					)
//			);

//			videoGameRepository.save(new VideoGame(
//					"Cyberpunk 2077",
//					"Cyberpunk 2077 is a 2020 action role-playing video game developed by CD Projekt Red and published by CD Projekt, based on video game designer Mike Pondsmith's game series. Set in a dystopian Cyberpunk universe, the player assumes the role of \"V\" (played by Gavin Drea/Cherami Leigh), a mercenary in the fictional Californian city known as \"Night City\", where they deal with the fallout from a heist gone wrong that results in an experimental cybernetic \"bio-chip\" containing an engram of the legendary rock star and terrorist Johnny Silverhand (played by Keanu Reeves) threatening to slowly overwrite V's mind; as the story progresses V and Johnny must work together to find a way to be separated and save V's life.",
//					95,
//					"https://cdna.artstation.com/p/assets/images/images/033/037/886/large/artur-tarnowski-malemain.jpg?1608208334",
//					"CD Projekt",
//					new Date(2020, 11,10))
//			);

			videoGameRepository.save(new VideoGame(
					"Outer Wilds",
					"Outer Wilds is a 2019 action-adventure game developed by Mobius Digital and published by Annapurna Interactive. It first released for Windows, Xbox One, and PlayStation 4 before releasing for PlayStation 5 and Xbox Series X/S in 2022. The game features the player character exploring a solar system stuck in a 22-minute time loop that ends with the star going supernova.",
					100,
					"https://cdn.akamai.steamstatic.com/steam/apps/753640/header.jpg?t=1687369978",
					"Mobius Digital",
					new Date(2019, 4, 28)
			));

			videoGameRepository.save(new VideoGame(
					"Ôkami",
					"Ôkami (Japanese: 大神, lit. \"great god\" or \"great spirit\"; also 狼, \"wolf\")[2] is an action-adventure video game developed by Clover Studio and published by Capcom. It was released for PlayStation 2 in 2006 in Japan and North America, and in 2007 in Europe and Australia. After the closure of Clover Studio a few months after the release, a port for Wii was developed by Ready at Dawn, Tose, and Capcom, and released in 2008.",
					93,
					"https://cdn.akamai.steamstatic.com/steam/apps/587620/header.jpg?t=1643674210",
					"Capcom",
					new Date(2006, 3, 20)
			));

			videoGameRepository.save(new VideoGame(
					"RimWorld",
					"RimWorld is a construction and management simulation video game developed and published by Canadian-based developer Ludeon Studios.[3] Originally called Eclipse Colony, it was initially released as a Kickstarter crowdfunding project in early access for Microsoft Windows, macOS, and Linux in November 2013, and was released on October 17, 2018. The game was released for PlayStation 4 and Xbox One as RimWorld Console Edition on July 29, 2022, with development and publishing being handled by Double Eleven.[4] Rather than a test of skill or a challenge, the game is intended to serve as an AI-powered \"story generator\", where the game is used as the medium for players to experience narrative adventures. The game has received generally positive reviews from critics.",
					96,
					"https://cdn.akamai.steamstatic.com/steam/apps/294100/header.jpg?t=1676391313",
					"Ludeon Studios",
					new Date(2022, 6, 29)
			));

			videoGameRepository.save(new VideoGame(
					"Microsoft Flight Simulator",
					"Microsoft Flight Simulator is an amateur flight simulator developed by Asobo Studio and published by Xbox Game Studios. It is an entry in the Microsoft Flight Simulator series which began in 1982, and was preceded by Microsoft Flight Simulator X in 2006. The game is a return of the series after 14 years, with development beginning six years prior to its release. It was released on August 18, 2020, for Windows, with a virtual reality (VR) version released in December of the same year as part of the free Sim 2 update. Microsoft Flight Simulator is the first game in the series to see a VR and console release, with it being released on the Xbox Series X and Series S on July 27, 2021.",
					91,
					"https://cdn.akamai.steamstatic.com/steam/apps/1250410/header.jpg?t=1689193265",
					"Asobo Studio",
					new Date(2020, 7, 18)
			));

			videoGameRepository.save(new VideoGame(
					"Final Fantasy VII",
					"Final Fantasy VII is a 1997 role-playing video game developed by Square for the PlayStation console and the seventh main installment in the Final Fantasy series. Square published the game in Japan, and it was released in other regions by Sony Computer Entertainment, becoming the first game in the main series to have a PAL release. The game's story follows Cloud Strife, a mercenary who joins an eco-terrorist organization to stop a world-controlling megacorporation from using the planet's life essence as an energy source. Events send Cloud and his allies in pursuit of Sephiroth, a superhuman who seeks to wound the planet and harness its healing power to be reborn as a god. During their journey, Cloud bonds with his party members, including Aerith Gainsborough, who holds the secret to saving their world.",
					90,
					"https://cdn.akamai.steamstatic.com/steam/apps/39140/header.jpg?t=1655449322",
					"Square",
					new Date(1997, 0, 31)
			));

			videoGameRepository.save(new VideoGame(
					"The Last of Us",
					"The Last of Us is a 2013 action-adventure game developed by Naughty Dog and published by Sony Computer Entertainment. Players control Joel, a smuggler tasked with escorting a teenage girl, Ellie, across a post-apocalyptic United States. The Last of Us is played from a third-person perspective. Players use firearms and improvised weapons and can use stealth to defend against hostile humans and cannibalistic creatures infected by a mutated fungus. In the online multiplayer mode, up to eight players engage in cooperative and competitive gameplay.",
					93,
					"https://cdn.akamai.steamstatic.com/steam/apps/1888930/header.jpg?t=1697567304",
					"Naughty Dog",
					new Date(2013, 5, 14)
			));

			videoGameRepository.save(new VideoGame(
					"The Elder Scrolls V : Skyrim",
					"The Elder Scrolls V: Skyrim is an action role-playing video game developed by Bethesda Game Studios and published by Bethesda Softworks. It is the fifth main installment in The Elder Scrolls series, following The Elder Scrolls IV: Oblivion (2006), and was released worldwide for Microsoft Windows, PlayStation 3, and Xbox 360 on November 11, 2011.",
					93,
					"https://cdn.akamai.steamstatic.com/steam/apps/489830/header.jpg?t=1650909796",
					"Bethesda Game Studios",
					new Date(2011, 10, 11)
			));

//			videoGameRepository.save(new VideoGame(
//					"The Legend of Zelda : Breath of the Wild",
//					"The Legend of Zelda: Breath of the Wild is a 2017 action-adventure game developed and published by Nintendo for the Nintendo Switch and Wii U. Set at the end of the Zelda timeline, the player controls an amnesiac Link as he sets out to save Princess Zelda and prevent Calamity Ganon from destroying the world. Players explore the open world of Hyrule while they collect items and complete objectives such as puzzles or side quests. Breath of the Wild's world is unstructured and encourages exploration and experimentation; the story can be completed in a nonlinear fashion.",
//					105,
//					"https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/10/the-legend-of-zelda-breath-of-the-wild-official-artwork.jpg?q=50&fit=contain&w=943&h=&dpr=1.5",
//					"Nintendo",
//					new Date(2017, 2, 3)
//			));

			videoGameRepository.save(new VideoGame(
					"FlatOut 2",
					"FlatOut 2 is a 2006 action racing video game developed by Bugbear Entertainment and published by Empire Interactive in Europe and Vivendi Universal Games in North America. It is the sequel to the 2004 game FlatOut.",
					94,
					"https://cdn.akamai.steamstatic.com/steam/apps/2990/header.jpg?t=1570210036",
					"Bugbear Entertainment",
					new Date(2006, 5, 30)
			));

			videoGameRepository.save(new VideoGame(
					"Frostpunk",
					"Frostpunk is a city-building survival game developed and published by 11 bit studios. Players take on the role of a leader in an alternate history late 19th century, in which they must build and maintain a city during a worldwide volcanic winter, managing resources, making choices on how to survive, and exploring the area outside their city for survivors, resources, or other useful items. The game features several scenarios to undertake, each with their own stories and different challenges.",
					84,
					"https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1695737003",
					"11 bit studios",
					new Date(2019, 9, 11)
			));

			videoGameRepository.save(new VideoGame(
					"Life is Strange",
					"Life Is Strange is a series of narrative adventure games published by Square Enix's External Studios. Created by Dontnod Entertainment, the series debuted with the eponymous first installment, which was released in five episodes throughout 2015. It was followed by a prequel, Life Is Strange: Before the Storm, which was developed by Deck Nine and released in three episodes throughout 2017, with a downloadable content (DLC) bonus episode released in early 2018. The sequel Life Is Strange 2 and its spin-off The Awesome Adventures of Captain Spirit were developed by Dontnod and released between 2018 and 2019. A third main installment, Life Is Strange: True Colors, was released in its entirety on 10 September 2021. Additionally, a remastered collection of the original game and its prequel was released in February 2022.",
					91,
					"https://cdn.akamai.steamstatic.com/steam/apps/319630/header.jpg?t=1662395426",
					"Square Enix",
					new Date(2015, 0,27)
			));

			videoGameRepository.save(new VideoGame(
					"The Witcher 3: Wild Hunt",
					"The Witcher 3: Wild Hunt[b] is a 2015 action role-playing game developed and published by CD Projekt. It is the sequel to the 2011 game The Witcher 2: Assassins of Kings and the third game in The Witcher video game series, played in an open world with a third-person perspective. The games follow the Witcher series of fantasy novels written by Andrzej Sapkowski.",
					98,
					"https://cdn.akamai.steamstatic.com/steam/apps/292030/header.jpg?t=1693590732",
					"CD Projekt",
					new Date(2015, 4, 19)
			));

			videoGameRepository.save(new VideoGame(
					"Portal",
					"Portal is a 2007 puzzle-platform game developed and published by Valve. It was released in a bundle, The Orange Box, for Windows, Xbox 360 and PlayStation 3, and has been since ported to other systems, including Mac OS X, Linux, Android (via Nvidia Shield), and Nintendo Switch.",
					97,
					"https://cdn.akamai.steamstatic.com/steam/apps/400/header.jpg?t=1696346380",
					"Valve",
					new Date(2007, 9, 10)
			));

			//Quiz 1 for Portal
			Question portalQuestion1 = new Question("What is the main tool used by the player in Portal?");
			Question portalQuestion2 = new Question("Who is the main antagonist in Portal?");
			questionRepository.save(portalQuestion1);
			questionRepository.save(portalQuestion2);
			List<Question> portalQuestions = Arrays.asList(portalQuestion1,portalQuestion2);

			Answer portalAnswer11 = new Answer("Portal Gun", true);
			Answer portalAnswer12 = new Answer("Gravity Gun", false);
			Answer portalAnswer13 = new Answer("Wrench", false);
			answerRepository.save(portalAnswer11);
			answerRepository.save(portalAnswer12);
			answerRepository.save(portalAnswer13);
			portalQuestions.get(0).setAnswers(Arrays.asList(portalAnswer11,portalAnswer12,portalAnswer13));

			Answer portalAnswer21 = new Answer("GLaDOS", true);
			Answer portalAnswer22 = new Answer("Chell", false);
			Answer portalAnswer23 = new Answer("Wheatley", false);
			answerRepository.save(portalAnswer21);
			answerRepository.save(portalAnswer22);
			answerRepository.save(portalAnswer23);
			portalQuestions.get(1).setAnswers(Arrays.asList(portalAnswer21,portalAnswer22,portalAnswer23));

			Quiz portalQuiz1 = new Quiz(
					"Portal Quiz",
					videoGameRepository.findByName("Portal"),
					userRepository.findByUsername("admin"),
					portalQuestions
			);
			quizRepository.save(portalQuiz1);

			//Quiz 2 for Portal
			Question portalQuestion5 = new Question("What is the name of the research company in Portal?");
			Question portalQuestion6 = new Question("What is the signature color of Portal's portals?");
			questionRepository.save(portalQuestion5);
			questionRepository.save(portalQuestion6);
			List<Question> portalQuestions3 = Arrays.asList(portalQuestion5, portalQuestion6);

			Answer portalAnswer51 = new Answer("Aperture Science", true);
			Answer portalAnswer52 = new Answer("Black Mesa", false);
			Answer portalAnswer53 = new Answer("Cyberdyne Systems", false);
			answerRepository.save(portalAnswer51);
			answerRepository.save(portalAnswer52);
			answerRepository.save(portalAnswer53);
			portalQuestions3.get(0).setAnswers(Arrays.asList(portalAnswer51, portalAnswer52, portalAnswer53));

			Answer portalAnswer61 = new Answer("Blue and Orange", true);
			Answer portalAnswer62 = new Answer("Green and Red", false);
			Answer portalAnswer63 = new Answer("Yellow and Purple", false);
			answerRepository.save(portalAnswer61);
			answerRepository.save(portalAnswer62);
			answerRepository.save(portalAnswer63);

			portalQuestions3.get(1).setAnswers(Arrays.asList(portalAnswer61,portalAnswer62,portalAnswer63));

			Quiz portalQuiz2 = new Quiz(
					"Portal Quiz 2",
					videoGameRepository.findByName("Portal"),
					userRepository.findByUsername("admin"),
					portalQuestions3
			);
			quizRepository.save(portalQuiz2);


			// Questions for CyberPunk 2077
//			Question cyberpunkQuestion1 = new Question("Who is the main protagonist in Cyberpunk 2077?");
//			Question cyberpunkQuestion2 = new Question("In which city does Cyberpunk 2077 take place?");
//			questionRepository.save(cyberpunkQuestion1);
//			questionRepository.save(cyberpunkQuestion2);
//			List<Question> cyberpunkQuestions = Arrays.asList(cyberpunkQuestion1, cyberpunkQuestion2);
//
//			Answer cyberpunkAnswer11 = new Answer("V", true);
//			Answer cyberpunkAnswer12 = new Answer("Johnny Silverhand", false);
//			Answer cyberpunkAnswer13 = new Answer("Dexter DeShawn", false);
//			answerRepository.save(cyberpunkAnswer11);
//			answerRepository.save(cyberpunkAnswer12);
//			answerRepository.save(cyberpunkAnswer13);
//			cyberpunkQuestions.get(0).setAnswers(Arrays.asList(cyberpunkAnswer11, cyberpunkAnswer12, cyberpunkAnswer13));
//
//			Answer cyberpunkAnswer21 = new Answer("Night City", true);
//			Answer cyberpunkAnswer22 = new Answer("Los Angeles", false);
//			Answer cyberpunkAnswer23 = new Answer("New York", false);
//			answerRepository.save(cyberpunkAnswer21);
//			answerRepository.save(cyberpunkAnswer22);
//			answerRepository.save(cyberpunkAnswer23);
//			cyberpunkQuestions.get(1).setAnswers(Arrays.asList(cyberpunkAnswer21, cyberpunkAnswer22, cyberpunkAnswer23));
//
//			Quiz cyberpunkQuiz = new Quiz(
//					"Cyberpunk 2077 Quiz",
//					videoGameRepository.findByName("Cyberpunk 2077"),
//					userRepository.findByUsername("admin"),
//					cyberpunkQuestions
//			);
//			quizRepository.save(cyberpunkQuiz);

			//Quiz for Outers Wilds
			Question outerWildsQuestion1 = new Question("What is the central mystery in Outer Wilds?");
			Question outerWildsQuestion2 = new Question("Which alien species built the Nomai technology?");
			questionRepository.save(outerWildsQuestion1);
			questionRepository.save(outerWildsQuestion2);
			List<Question> outerWildsQuestions = Arrays.asList(outerWildsQuestion1, outerWildsQuestion2);

			Answer outerWildsAnswer11 = new Answer("The disappearance of the Nomai", true);
			Answer outerWildsAnswer12 = new Answer("The nature of the Hearthian sun", false);
			Answer outerWildsAnswer13 = new Answer("The origin of the Interloper", false);
			answerRepository.save(outerWildsAnswer11);
			answerRepository.save(outerWildsAnswer12);
			answerRepository.save(outerWildsAnswer13);
			outerWildsQuestions.get(0).setAnswers(Arrays.asList(outerWildsAnswer11, outerWildsAnswer12, outerWildsAnswer13));

			Answer outerWildsAnswer21 = new Answer("Nomai", true);
			Answer outerWildsAnswer22 = new Answer("Hearthians", false);
			Answer outerWildsAnswer23 = new Answer("Anglerfish", false);
			answerRepository.save(outerWildsAnswer21);
			answerRepository.save(outerWildsAnswer22);
			answerRepository.save(outerWildsAnswer23);
			outerWildsQuestions.get(1).setAnswers(Arrays.asList(outerWildsAnswer21, outerWildsAnswer22, outerWildsAnswer23));

			Quiz outerWildsQuiz = new Quiz(
					"Outer Wilds Quiz",
					videoGameRepository.findByName("Outer Wilds"),
					userRepository.findByUsername("admin"),
					outerWildsQuestions
			);
			quizRepository.save(outerWildsQuiz);

			// Quiz for Frostpunk
			Question frostpunkQuestion1 = new Question("What is the central theme of Frostpunk?");
			Question frostpunkQuestion2 = new Question("Who is the leader of the city in Frostpunk?");
			questionRepository.save(frostpunkQuestion1);
			questionRepository.save(frostpunkQuestion2);
			List<Question> frostpunkQuestions = Arrays.asList(frostpunkQuestion1, frostpunkQuestion2);

			Answer frostpunkAnswer11 = new Answer("Survival in a frozen world", true);
			Answer frostpunkAnswer12 = new Answer("Building advanced technology", false);
			Answer frostpunkAnswer13 = new Answer("Political intrigue", false);
			answerRepository.save(frostpunkAnswer11);
			answerRepository.save(frostpunkAnswer12);
			answerRepository.save(frostpunkAnswer13);
			frostpunkQuestions.get(0).setAnswers(Arrays.asList(frostpunkAnswer11, frostpunkAnswer12, frostpunkAnswer13));

			Answer frostpunkAnswer21 = new Answer("The Captain", true);
			Answer frostpunkAnswer22 = new Answer("The Engineer", false);
			Answer frostpunkAnswer23 = new Answer("The Medic", false);
			answerRepository.save(frostpunkAnswer21);
			answerRepository.save(frostpunkAnswer22);
			answerRepository.save(frostpunkAnswer23);
			frostpunkQuestions.get(1).setAnswers(Arrays.asList(frostpunkAnswer21, frostpunkAnswer22, frostpunkAnswer23));

			Quiz frostpunkQuiz = new Quiz(
					"Frostpunk Quiz",
					videoGameRepository.findByName("Frostpunk"),
					userRepository.findByUsername("admin"),
					frostpunkQuestions
			);
			quizRepository.save(frostpunkQuiz);

		};
	}
}
