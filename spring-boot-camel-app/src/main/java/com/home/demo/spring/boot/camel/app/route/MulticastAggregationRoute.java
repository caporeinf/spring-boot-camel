package com.home.demo.spring.boot.camel.app.route;

import com.google.common.collect.Lists;
import com.home.demo.spring.boot.camel.app.processor.ListAggregationStrategy;
import org.apache.camel.LoggingLevel;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by renny on 5/21/17.
 */
@Component
public class MulticastAggregationRoute extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        AggregationStrategy myAggregationStrategy = new ListAggregationStrategy();
        List<String> listA = Lists.newArrayList("A");
        List<String> listB = Lists.newArrayList("B");
        from("direct:multicast")
                .routeId("multicastRoute")
                .multicast(myAggregationStrategy)
                .to("direct:A", "direct:B")
                .end()
                .log(LoggingLevel.INFO,log,"AGGREGATION RESULT \n ${body}");

        from("direct:A").setBody(constant(listA));
        from("direct:B").setBody(constant(listB));
    }
}
