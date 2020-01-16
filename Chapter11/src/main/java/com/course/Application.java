package com.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PreDestroy;

@Controller
@EnableScheduling
@SpringBootApplication
@MapperScan(value = "com.course.mapper")
public class Application {

    @RequestMapping(value = "/")
    public String home(){
        return "Hello World!";
    }

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class,args);
    }

    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
