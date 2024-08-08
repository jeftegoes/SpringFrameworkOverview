package com.configbean.config_bean_project.rest;

import com.configbean.config_bean_project.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Payment payment;

    @Autowired
    public DemoController(@Qualifier("creditCardPayment") Payment payment) {
        this.payment = payment;
    }

    @GetMapping("/")
    public String getPaymentName() {
        return this.payment.getName();
    }
}
