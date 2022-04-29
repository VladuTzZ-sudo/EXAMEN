package com.example.pe_bune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PeBuneApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeBuneApplication.class, args);
    }
}
