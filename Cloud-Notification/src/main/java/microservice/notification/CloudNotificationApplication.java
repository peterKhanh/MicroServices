package microservice.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNotificationApplication.class, args);
	}

}
