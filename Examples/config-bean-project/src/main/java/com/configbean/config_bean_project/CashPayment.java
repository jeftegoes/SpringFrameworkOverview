package com.configbean.config_bean_project;

import org.springframework.stereotype.Component;

@Component
public class CashPayment  implements Payment {
    public CashPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    public String getName() {
        return "Cash payment.";
    }
}
