package com.dependencyinjection.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Payment payment;

    @Autowired
    public DemoController(Payment payment) {
        this.payment = payment;
    }

    @GetMapping("/payment/getName")
    public String getPaymentName() {
        return payment.getName();
    }
}
