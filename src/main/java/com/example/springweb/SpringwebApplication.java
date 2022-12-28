package com.example.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringwebApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/springweb/real-application.yml";

    public static void main(String[] args) {
//        SpringApplication.run(SpringwebApplication.class, args);
        new SpringApplicationBuilder(SpringwebApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
