package com.example.poverty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ccphamy
 */
@EnableAsync
@SpringBootApplication
public class PovertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PovertyApplication.class, args);
    }

}
