package com.example.learnverse;

import com.example.learnverse.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(RsaKeyProperties.class)
public class LearnVerseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnVerseApplication.class, args);
    }

}
