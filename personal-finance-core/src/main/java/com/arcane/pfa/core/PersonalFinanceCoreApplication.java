package com.arcane.pfa.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonalFinanceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceCoreApplication.class, args);
    }

}
