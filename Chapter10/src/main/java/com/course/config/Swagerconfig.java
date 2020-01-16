package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //自动加载配置文件
@EnableSwagger2
public class Swagerconfig {
    @Bean
    public ApiSelectorBuilder api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("My inferface")
                .contact(new Contact("dazhou","url","1105@qq.com"))
                .description("Description  info")
                .version("1.1")
                .build();
    }
}
