package com.example.scheduled_windows_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ScheduledWindowsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledWindowsServiceApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void doPeriodicWork1() {
        System.out.println("Executing periodic work 1...");
    }

    @Scheduled(fixedRate = 2000)
    public void doPeriodicWork2() {
        System.out.println("Executing periodic work 2...");
    }

}
