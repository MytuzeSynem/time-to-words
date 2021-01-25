package com.example.date.to.words;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public DateToWords dateToWordsConversion() {
        return new DateToWords();
    }
}
