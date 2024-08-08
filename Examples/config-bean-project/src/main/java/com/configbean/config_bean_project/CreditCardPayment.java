package com.configbean.config_bean_project;


public class CreditCardPayment implements Payment {
    public CreditCardPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    public String getName() {
        return "Credit card payment.";
    }
}
