package com.jt24.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jt24.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.jt24.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}
