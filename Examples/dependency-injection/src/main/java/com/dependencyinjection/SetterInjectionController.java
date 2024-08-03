package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetterInjectionController {
    private Payment payment;

    @Autowired
    public void setPayment(@Qualifier("pixPayment") Payment payment) {
        this.payment = payment;
    }

    @GetMapping("/setter/payment/getName")
    public String getPaymentName() {
        return "Setter: " + payment.getName();
    }
}
