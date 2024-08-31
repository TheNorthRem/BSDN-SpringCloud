package com.bupt.bnlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BnLoggerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BnLoggerAppApplication.class, args);
    }

}
