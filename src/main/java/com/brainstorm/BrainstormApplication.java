package com.brainstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableMongoAuditing
public class BrainstormApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrainstormApplication.class, args);
    }

}
