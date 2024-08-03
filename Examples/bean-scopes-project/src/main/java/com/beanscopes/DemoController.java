package com.beanscopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Payment payment;
    private Payment anotherPayment;

    @Autowired
    public DemoController(
            @Qualifier("pixPayment") Payment payment,
            @Qualifier("pixPayment") Payment anotherPayment) {

        System.out.println("In constructor: " + getClass().getSimpleName());
        this.payment = payment;
        this.anotherPayment = anotherPayment;
    }

    @GetMapping("/")
    public String getPaymentName() {
        return this.payment.getName();
    }

    @GetMapping("/check")
    public String check() {
        // Singleton = true
        // Prototype = false
        return "Comparing beans: payment == anotherPayment, " + (payment == anotherPayment);
    }
}
