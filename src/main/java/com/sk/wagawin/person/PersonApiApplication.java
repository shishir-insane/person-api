package com.sk.wagawin.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PersonApiApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PersonApiApplication.class, args);
    }
}
