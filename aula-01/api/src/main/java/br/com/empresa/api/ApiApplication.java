package br.com.empresa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.empresa.api.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
