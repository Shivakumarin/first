package Discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OnlineServiceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineServiceBookingApplication.class, args);
	}

}
