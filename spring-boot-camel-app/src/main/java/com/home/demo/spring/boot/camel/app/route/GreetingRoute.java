package com.home.demo.spring.boot.camel.app.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by renny on 5/21/17.
 */
@Component
public class GreetingRoute extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:getGreetingMessage")
                .transform(simple("Hello World ${header.id} !!!"));
    }
}
