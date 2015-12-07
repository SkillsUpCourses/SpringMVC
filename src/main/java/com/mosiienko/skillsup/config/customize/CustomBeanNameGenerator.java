package com.mosiienko.skillsup.config.customize;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

import java.beans.Introspector;

public class CustomBeanNameGenerator implements BeanNameGenerator {
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String beanClassName = Introspector.decapitalize(definition.getBeanClassName() + "byRomanMosiienko");
        System.out.println("Instantiating bean with name: " + beanClassName);
        return beanClassName;
    }
}