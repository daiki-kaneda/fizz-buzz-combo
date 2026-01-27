package com.example.fizz_buzz_combo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FizzBuzzComboApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzComboApplication.class, args);
	}

}
