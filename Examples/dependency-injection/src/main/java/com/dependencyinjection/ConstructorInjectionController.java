package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructorInjectionController {
    private Payment payment;

    @Autowired
    public ConstructorInjectionController(Payment payment) {
        this.payment = payment;
    }

    @GetMapping("/constructor/payment/getName")
    public String getPaymentName() {
        return "Constructor: " + payment.getName();
    }
}
