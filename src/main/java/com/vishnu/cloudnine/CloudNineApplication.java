package com.vishnu.cloudnine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableConfigurationProperties()
@SpringBootApplication
public class CloudNineApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CloudNineApplication.class, args);
    }

}

