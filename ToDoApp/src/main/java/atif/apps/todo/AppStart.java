package atif.apps.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("atif.apps.todo")
@SpringBootApplication
public class AppStart {
	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}
}
