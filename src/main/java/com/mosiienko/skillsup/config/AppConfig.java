package com.mosiienko.skillsup.config;

import com.mosiienko.skillsup.config.customize.CustomBeanNameGenerator;
import com.mosiienko.skillsup.config.customize.ProfilingHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Class {@link AppConfig
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 05.12.15
 */
@Configuration
@ComponentScan(basePackages = {
        "com.mosiienko.skillsup.config",
        "com.mosiienko.skillsup.repositories",
        "com.mosiienko.skillsup.services"
}, nameGenerator = CustomBeanNameGenerator.class)
@Import({PersistenceConfig.class})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
