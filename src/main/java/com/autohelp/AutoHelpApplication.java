package com.autohelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@ComponentScan
//@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class AutoHelpApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AutoHelpApplication.class, args);
    }


    @Bean
    @ConfigurationProperties(prefix="spring.dataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
