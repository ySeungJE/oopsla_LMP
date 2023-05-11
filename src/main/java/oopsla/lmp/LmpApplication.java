package oopsla.lmp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class LmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmpApplication.class, args);
	}


}
