package com.elvis.discoveryserverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryserverApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryserverApiApplication.class, args);
    }

}
