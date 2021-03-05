package de.imginvoice.imgtopdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.imginvoice.imgtopdf.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ImgtopdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImgtopdfApplication.class, args);
	}

}
