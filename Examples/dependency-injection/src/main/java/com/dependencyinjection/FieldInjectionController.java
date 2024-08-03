package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {
    @Autowired
    @Qualifier("cashPayment")
    private Payment payment;

    @GetMapping("/field/payment/getName")
    public String getPaymentName() {
        return "Field: " + payment.getName();
    }
}
