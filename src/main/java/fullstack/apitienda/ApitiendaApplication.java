package fullstack.apitienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "fullstack.apitienda.model") 
@EnableJpaRepositories(basePackages = "fullstack.apitienda.repository")
public class ApitiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApitiendaApplication.class, args);
	}

}
