package com.mosiienko.skillsup.config;

import com.mosiienko.skillsup.config.customize.CustomBeanNameGenerator;
import com.mosiienko.skillsup.config.customize.ProfilingHandlerBeanPostProcessor;
import com.mosiienko.skillsup.lookup.ColorFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

/**
 * Class {@link AppConfig
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 05.12.15
 */
@Configuration
@ComponentScan(basePackages = {
        "com.mosiienko.skillsup.*"
}, nameGenerator = CustomBeanNameGenerator.class)
public class AppConfig {

    @Bean
    public ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
        return new ProfilingHandlerBeanPostProcessor();
    }

    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            public Color setColor() {
                return color();
            }
        };
    }
}
