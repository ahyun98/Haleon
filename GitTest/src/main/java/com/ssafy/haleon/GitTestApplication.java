package com.ssafy.haleon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitTestApplication.class, args);
		System.out.println("Hello GitHub!");
	}

}
