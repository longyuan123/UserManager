package com.course;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

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
