package cloud.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDiscoveryServiceApplication.class, args);
	}

}
