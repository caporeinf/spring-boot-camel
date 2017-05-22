package com.home.demo.spring.boot.camel.app.route;

import org.apache.camel.ProducerTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by renny on 5/21/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MulticastAggregationRouteTest {

    @Autowired
    ProducerTemplate producerTemplate;

    private static Logger logger = LoggerFactory.getLogger(MulticastAggregationRouteTest.class);
    private boolean isCamelContextInitialized = false;

    @Before
    public void initializeCamelContext() throws Exception {
        if (!isCamelContextInitialized) {
            logger.info("Waiting for Camel Context to become initialized.");
            Thread.sleep(5000L);
        }
    }

    @Test
    public void testRoute() {
        logger.info("Starting test.");
        producerTemplate.sendBody("direct:multicast", "body");
    }
}
