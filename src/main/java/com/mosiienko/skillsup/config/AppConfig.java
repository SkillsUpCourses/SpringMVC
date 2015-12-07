package com.mosiienko.skillsup.config;

import com.mosiienko.skillsup.config.customize.CustomBeanNameGenerator;
import com.mosiienko.skillsup.config.customize.ProfilingHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class {@link AppConfig
 *
 * @author RomanMosiienko
 * @version 1.0
 * @since 05.12.15
 */
@Configuration
@ComponentScan(basePackages = {
        "com.mosiienko.skillsup.repositories",
//        "com.mosiienko.skillsup.config",
        "com.mosiienko.skillsup.services"
}, nameGenerator = CustomBeanNameGenerator.class)
public class AppConfig {
    @Bean
    public ProfilingHandlerBeanPostProcessor myBean() throws Exception {
        return new ProfilingHandlerBeanPostProcessor();
    }

}
