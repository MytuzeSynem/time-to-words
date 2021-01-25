package com.example.date.to.words;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class DateToWordsApplication {

	private final DateToWords dateToWords;

	public static void main(String[] args) {
		SpringApplication.run(DateToWordsApplication.class, args);
	}

}


