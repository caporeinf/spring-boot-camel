package com.home.demo.spring.boot.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Created by renny on 5/21/17.
 */
@SpringBootApplication
@Import(value = {ServiceConfiguration.class})
public class CamelApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CamelApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CamelApp.class);
    }
}
