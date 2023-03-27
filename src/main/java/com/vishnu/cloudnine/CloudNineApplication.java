package com.vishnu.cloudnine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties()
@SpringBootApplication
public class CloudNineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNineApplication.class, args);
    }

}

