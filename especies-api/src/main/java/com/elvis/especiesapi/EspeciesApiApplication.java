package com.elvis.especiesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EspeciesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspeciesApiApplication.class, args);
    }

}
