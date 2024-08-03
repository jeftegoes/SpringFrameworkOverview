package com.lazyinitialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Payment payment;

    @Autowired
    public DemoController(@Qualifier("pixPayment") Payment payment) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.payment = payment;
    }

    @GetMapping("/")
    public String getPaymentName() {
        return payment.getName();
    }
}
