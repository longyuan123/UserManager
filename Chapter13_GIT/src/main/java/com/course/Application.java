package com.course;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Controller
@EnableScheduling
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@Api
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
