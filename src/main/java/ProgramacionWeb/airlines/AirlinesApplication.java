package ProgramacionWeb.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("ProgramacionWeb.*.*")
@ComponentScan(basePackages = { "ProgramacionWeb.*" })
@EntityScan("ProgramacionWeb.*") 
@SpringBootApplication
public class AirlinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}

}
