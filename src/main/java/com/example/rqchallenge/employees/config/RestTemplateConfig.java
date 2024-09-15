package com.example.rqchallenge.employees.config;

import com.example.rqchallenge.employees.exception.handler.RestTemplateResponseExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseExceptionHandler());
        return restTemplate;
    }

}
