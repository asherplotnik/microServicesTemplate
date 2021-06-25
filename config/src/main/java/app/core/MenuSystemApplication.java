package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MenuSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuSystemApplication.class, args);
	}

}
