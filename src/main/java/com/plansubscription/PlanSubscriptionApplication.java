package com.plansubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PlanSubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanSubscriptionApplication.class, args);
	}

}
