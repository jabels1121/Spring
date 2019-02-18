package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:properties/sport.properties")
public class SportConfig {

    @Bean
    public FortuneService unHappyFortuneService() {
        return new UnHappyFortuneService();
    }

    @Bean
    @Scope("singleton")
    public Coach swimCoach() {
        return new SwimCoach(unHappyFortuneService());
    }

}
