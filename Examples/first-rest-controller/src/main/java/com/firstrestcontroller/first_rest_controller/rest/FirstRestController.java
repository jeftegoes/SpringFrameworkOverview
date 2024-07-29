package com.firstrestcontroller.first_rest_controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
    @GetMapping("/")
    public String getValue() {
        return "Works fine!";
    }
}
