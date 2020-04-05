package atif.apps.todo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("atif.apps.todo.dao")
public class JpaConfig {

}
