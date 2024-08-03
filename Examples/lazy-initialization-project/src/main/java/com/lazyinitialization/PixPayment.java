package com.lazyinitialization;

import org.springframework.stereotype.Component;

@Component
public class PixPayment implements Payment {
    public PixPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return "Pix Payment.";
    }
}
