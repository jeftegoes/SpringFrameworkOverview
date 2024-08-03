package com.beanscopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PixPayment implements Payment {
    public PixPayment() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    public String getName() {
        return "Pix payment.";
    }
}
