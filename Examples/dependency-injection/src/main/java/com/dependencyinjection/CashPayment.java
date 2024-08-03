package com.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class CashPayment implements Payment {
    @Override
    public String getName() {
        return "Cash Payment";
    }
}
