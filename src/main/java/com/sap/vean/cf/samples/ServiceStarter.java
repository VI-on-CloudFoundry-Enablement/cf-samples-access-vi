package com.sap.vean.cf.samples;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServiceStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceStarter.class).run(args);
    }

}
