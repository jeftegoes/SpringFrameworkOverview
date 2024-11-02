package com.example.scheduled_windows_service.loggers;

import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowsEventLogger {
    private static final Logger logger = Logger.getLogger(WindowsEventLogger.class.getName());
    private static final String SOURCE = "MySpringBootService";

    static {
        // Register event source if not already registered
        if (!Advapi32Util.registryKeyExists(WinReg.HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Services\\EventLog\\Application\\" + SOURCE)) {
            Advapi32Util.registryCreateKey(WinReg.HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Services\\EventLog\\Application\\" + SOURCE);
        }
    }

    public static void logInfo(String message) {
        log(message, WinNT.EVENTLOG_INFORMATION_TYPE);
    }

    public static void logWarning(String message) {
        log(message, WinNT.EVENTLOG_WARNING_TYPE);
    }

    public static void logError(String message) {
        log(message, WinNT.EVENTLOG_ERROR_TYPE);
    }

    private static void log(String message, int type) {
        boolean success = Advapi32.INSTANCE.ReportEvent(
                Advapi32.INSTANCE.RegisterEventSource(null, SOURCE),
                type,
                0,
                0x1000,  // Event ID, custom value
                null,
                1,
                0,
                new String[]{message},
                null
        );
        if (!success) {
            logger.log(Level.SEVERE, "Failed to log to Event Viewer: " + message);
        }
    }
}
