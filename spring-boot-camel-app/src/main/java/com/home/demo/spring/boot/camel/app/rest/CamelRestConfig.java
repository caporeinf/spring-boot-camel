package com.home.demo.spring.boot.camel.app.rest;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Created by renny on 2/14/17.
 */
@Component
public class CamelRestConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().
                component("servlet").
                dataFormatProperty("prettyPrint","true").
                bindingMode(RestBindingMode.json)
                .jsonDataFormat("json-gson").
                port(8080).
                enableCORS(true).
                apiContextPath("api-doc").
                apiProperty("api.title","Demo Spring Boot Camel API").
                apiProperty("api.version","1.0.0");

        onException(Exception.class)
                .handled(true)
                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(500))
                .setBody(simple("Internal Server Error"));

        errorHandler(loggingErrorHandler(log).level(LoggingLevel.ERROR));

    }
}
