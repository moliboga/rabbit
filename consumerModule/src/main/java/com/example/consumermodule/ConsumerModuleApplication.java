package com.example.consumermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@SpringBootApplication
public class ConsumerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerModuleApplication.class, args);
    }
}
