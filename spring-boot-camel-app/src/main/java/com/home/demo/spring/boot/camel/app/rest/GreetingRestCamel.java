package com.home.demo.spring.boot.camel.app.rest;

import org.apache.camel.spring.SpringRouteBuilder;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by renny on 5/21/17.
 */
@Component
public class GreetingRestCamel extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("message")
                .description("Greeting Service")

                .get("{id}").outType(String.class)
                .description("Get Message for target")
                .responseMessage().code(HttpStatus.SC_OK).message("Message found").endResponseMessage()
                .responseMessage().code(HttpStatus.SC_NOT_FOUND).message("Message not found").endResponseMessage()
                .responseMessage().code(HttpStatus.SC_INTERNAL_SERVER_ERROR).message("Internal server error").endResponseMessage()
                .param().name("id").description("The target message").endParam()
                .to("direct:getGreetingMessage")
        ;

    }
}
