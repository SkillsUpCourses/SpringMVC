package com.mosiienko.skillsup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@PropertySource("classpath:persistence_config.properties")
public class PersistenceConfig implements TransactionManagementConfigurer {
    @Value("${dialect}")
    private String dialect;
    @Value("${hbm2ddlAuto}")
    private String hbm2ddlAuto;
    @Value("${packageToScan}")
    private String packageToScan;
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    /**
     * Configure {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean} instance with sent data from {@link javax.sql.DataSource}
     *
     * @return configured {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean} instance
     */
    @Bean
    @Autowired
    @DependsOn("dataSource")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(packageToScan);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put(DIALECT, dialect);
        jpaProperties.put(HBM2DDL_AUTO, hbm2ddlAuto);
        jpaProperties.put(SHOW_SQL, true);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        initDataSourceDefaultData(dataSource);
        return dataSource;
    }

    private void initDataSourceDefaultData(DataSource dataSource) {
        try {
            Connection connection = null;
            connection = dataSource.getConnection();
            Resource resource = new ClassPathResource("/default_data.sql");
            ScriptUtils.executeSqlScript(connection, resource);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
