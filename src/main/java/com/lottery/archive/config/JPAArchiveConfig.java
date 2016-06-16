package com.lottery.archive.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Sahinn
 * @date 16/6/13
 * 使用Spring Data,作为持久层框架,配置需要扫描的包
 */
@Configuration
@PropertySource("classpath:archive.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.lottery.archive.dao.archive", entityManagerFactoryRef="archiveEntityManagerFactory"
        , transactionManagerRef = "archiveTransactionManager")
public class JPAArchiveConfig {

    @Autowired
    private Environment env;

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.query.substitutions", env.getProperty("hibernate.query.substitutions"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.connection.autocommit", env.getProperty("hibernate.connection.autocommit"));
        properties.setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        return properties;
    }

    @Bean(name = "archiveEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean archiveEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(archiveDataSource());

        //配置需要扫描的包
        em.setPackagesToScan(new String[] {"com.lottery.archive.entity.archive"});

        em.setPersistenceUnitName("archiveEntityManager");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource archiveDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("lottery.archive.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("lottery.archive.jdbc.url"));
        dataSource.setUsername(env.getProperty("lottery.archive.jdbc.username"));
        dataSource.setPassword(env.getProperty("lottery.archive.jdbc.password"));
        dataSource.setMaxActive(Integer.valueOf(env.getProperty("lottery.archive.jdbc.maxActive")));
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    @Bean(name="archiveTransactionManager")
//    @Qualifier(value = "archiveTransactionManager")
    public PlatformTransactionManager archiveTransactionManager(){
        EntityManagerFactory factory = archiveEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
