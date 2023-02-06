package oopsla.lmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmpApplication.class, args);
	}

}
