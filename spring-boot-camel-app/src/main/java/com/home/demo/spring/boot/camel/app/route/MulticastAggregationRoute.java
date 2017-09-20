package com.home.demo.spring.boot.camel.app.route;

import com.google.common.collect.Lists;
import com.home.demo.spring.boot.camel.app.processor.ListAggregationStrategy;
import com.home.demo.spring.boot.camel.app.processor.MapAggregationStrategy;
import org.apache.camel.LoggingLevel;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by renny on 5/21/17.
 */
@Component
public class MulticastAggregationRoute extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        AggregationStrategy listAggregationStrategy = new ListAggregationStrategy();
        MapAggregationStrategy mapAggregationStrategy = new MapAggregationStrategy();
        List<String> listA = Lists.newArrayList("A");
        List<String> listB = Lists.newArrayList("B");
        Map<String,Object> mapA = Collections.singletonMap("mapA","bodyMapA");
        Map<String,Object> mapB = Collections.singletonMap("mapB","bodyMapB");
        Map<String,Object> mapC = Collections.singletonMap("mapC","bodyMapC");

        from("direct:multicast").multicast(listAggregationStrategy)
                .to("direct:A", "direct:B").end()
                .log(LoggingLevel.INFO,log,"LIST AGGREGATION RESULT \n ${body}");

        from("direct:multicast2").multicast(mapAggregationStrategy)
                .to("direct:mapA","direct:mapB","direct:mapC").end()
                .log(LoggingLevel.INFO,log,"MAP AGGREGATION RESULT \n ${body}");

        from("direct:A").setBody(constant(listA));
        from("direct:B").setBody(constant(listB));

        from("direct:mapA").setBody(constant(mapA));
        from("direct:mapB").setBody(constant(mapB));
        from("direct:mapC").setBody(constant(mapC));
    }
}
