package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//在启动类上添加注解@EnableAutoConfiguration 或 @SpringBootApplication
@SpringBootApplication
public class HelloWorldController {


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
