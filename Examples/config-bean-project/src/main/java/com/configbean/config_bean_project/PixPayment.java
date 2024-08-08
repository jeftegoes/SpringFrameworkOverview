package com.configbean.config_bean_project;

import org.springframework.stereotype.Component;

@Component
public class PixPayment implements Payment {
    public PixPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    public String getName() {
        return "Pix payment.";
    }
}
