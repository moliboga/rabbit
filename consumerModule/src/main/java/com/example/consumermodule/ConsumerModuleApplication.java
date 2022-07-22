package com.example.consumermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ConsumerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerModuleApplication.class, args);
    }
}
