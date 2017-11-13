package com.home.demo.sbcamel.service;

import com.home.demo.sbcamel.common.CommonConfiguration;
import com.home.demo.sbcamel.domain.DomainConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by renny on 5/21/17.
 */
@Configuration
@Import(value = {CommonConfiguration.class,DomainConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class ServiceConfiguration {
}
