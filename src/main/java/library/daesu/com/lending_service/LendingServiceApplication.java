package library.daesu.com.lending_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LendingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LendingServiceApplication.class, args);
	}

}
