package com.lazyinitialization;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CashPayment implements Payment {
    public CashPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return "Cash Payment";
    }
}
