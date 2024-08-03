package com.dependencyinjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PixPayment implements Payment {
    public String getName() {
        return "Pix Payment.";
    }
}
