package com.test;

import com.test.componet.DataConverter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by deliriy on 06.10.2016.
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:app_config.properties")
public class AppConfig {

    @Value("${connection_uri}")
    String connection_uri;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Connection jsoupConnectionBuilder() {
        return Jsoup.connect(connection_uri)
                .ignoreContentType(true)
                .timeout(2000);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new DataConverter());
        return modelMapper;
    }

}
