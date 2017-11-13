package com.home.demo.sbcamel.app.processor;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renny on 6/23/17.
 */
public class MapAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Map<String,Object> newBody = newExchange.getIn().getBody(Map.class);
        Map<String,Object> map;
        if (oldExchange == null) {
            map = new HashMap<>();
            map.put(newExchange.getProperty(Exchange.MULTICAST_INDEX,String.class),newBody);
            newExchange.getIn().setBody(map);
            return newExchange;
        } else {
            map = oldExchange.getIn().getBody(Map.class);
            map.put(newExchange.getProperty(Exchange.MULTICAST_INDEX,String.class),newBody);
            return oldExchange;
        }
    }
}
