package com.example.scheduled_windows_service;

import com.example.scheduled_windows_service.loggers.WindowsEventLogger;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
public class ScheduledWindowsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledWindowsServiceApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void doPeriodicWork1() {
        WindowsEventLogger.logInfo("Executing periodic work 1...");
    }

    @Scheduled(fixedRate = 2000)
    public void doPeriodicWork2() {
        WindowsEventLogger.logInfo("Executing periodic work 2...");
    }
}