package com.home.demo.sbcamel.app.processor;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by renny on 5/21/17.
 */
public class ListAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Object newBody = newExchange.getIn().getBody();
        Collection list;
        Consumer<Collection> consumer = (Collection c) -> {
            if (newBody instanceof Collection) {
                c.addAll((Collection) newBody);
            } else {
                c.add(newBody);
            }
        };

        if (oldExchange == null) {
            list = new ArrayList<>();
            consumer.accept(list);
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            list = oldExchange.getIn().getBody(List.class);
            consumer.accept(list);
            return oldExchange;
        }
    }
}
