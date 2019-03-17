package com.sonar.twittersolr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
public class TwitterSolrApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterSolrApplication.class, args);
    }
}
