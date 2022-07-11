package first_commit.sung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class SungApplication {

	public static void main(String[] args) {
		SpringApplication.run(SungApplication.class, args);
	}

}
