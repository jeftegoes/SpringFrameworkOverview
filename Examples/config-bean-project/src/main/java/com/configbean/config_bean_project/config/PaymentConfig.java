package com.configbean.config_bean_project.config;

import com.configbean.config_bean_project.CreditCardPayment;
import com.configbean.config_bean_project.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Bean
    public Payment creditCardPayment() {
        return new CreditCardPayment();
    }
}
