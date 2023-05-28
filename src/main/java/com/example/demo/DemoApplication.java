package com.example.demo;

import com.example.demo.service.TraversalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final TraversalService traversalService;

	public DemoApplication(TraversalService traversalService) {

		this.traversalService = traversalService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		traversalService.performTraversal(18l);

	}
}
