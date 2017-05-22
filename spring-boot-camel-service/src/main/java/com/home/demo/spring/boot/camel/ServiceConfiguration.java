package com.home.demo.spring.boot.camel;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by renny on 5/21/17.
 */
@Configuration
@Import(value = {CommonConfiguration.class,DomainConfiguration.class})
public class ServiceConfiguration {
}
