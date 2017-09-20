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
    private ProducerTemplate producerTemplate;

    private static Logger logger = LoggerFactory.getLogger(MulticastAggregationRouteTest.class);

    @Before
    public void initializeCamelContext() throws Exception {
        logger.info("Waiting 5 seconds for Camel Context to become initialized.");
        Thread.sleep(5000L);
    }

    @Test
    public void callMulticastRoute() {
        logger.info("Starting test.");
        producerTemplate.sendBody("direct:multicast", "body");
    }

    @Test
    public void callMulticastRoute2() {
        logger.info("Starting test.");
        producerTemplate.sendBody("direct:multicast2", "body");
    }
}
