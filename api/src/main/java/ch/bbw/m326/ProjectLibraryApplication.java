package ch.bbw.m326;

import ch.bbw.m326.database.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Application class contains the main SpringBoot method.
 */
@SpringBootApplication
public class ProjectLibraryApplication {

	/**
	 * The main method starts the SpringBoot application.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjectLibraryApplication.class, args);
		Manager mng = new Manager();
		try {
			mng.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
