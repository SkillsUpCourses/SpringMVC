package com.ksu.skillsup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan(basePackages = {
        "com.ksu.skillsup.config",
        "com.ksu.skillsup.controllers",
        "com.ksu.skillsup.dao",
        "com.ksu.skillsup.service",
        "com.ksu.skillsup.eventlistener"
})
@PropertySource(value = {"classpath:ContactBookMaximumSize.properties"})
@Import({ WebMvcConfig.class,HibernateConfiguration.class})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
