package com.example.shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.shops.repository")
public class ShopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }

}
