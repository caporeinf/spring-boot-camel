package com.home.demo.sbcamel.app.rest;

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
                .description("Get message")
                .responseMessage().code(HttpStatus.SC_OK).message("Message found").endResponseMessage()
                .responseMessage().code(HttpStatus.SC_NOT_FOUND).message("Message not found").endResponseMessage()
                .responseMessage().code(HttpStatus.SC_INTERNAL_SERVER_ERROR).message("Internal server error").endResponseMessage()
                .param().name("id").description("The message target").endParam()
                .to("direct:getGreetingMessage")
        ;

    }
}
