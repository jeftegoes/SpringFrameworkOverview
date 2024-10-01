package com.example.intercept_http_request_response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterceptHttpRequestResponseApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptHttpRequestResponseApplication.class, args);
    }
}
