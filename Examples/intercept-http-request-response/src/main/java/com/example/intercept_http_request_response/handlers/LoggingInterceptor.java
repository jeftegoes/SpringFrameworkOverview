package com.example.intercept_http_request_response.handlers;

import com.example.intercept_http_request_response.utils.Log;
import com.google.gson.Gson;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RequestScope
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    private final StopWatch stopWatch = new StopWatch();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        stopWatch.start();

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if (request.getDispatcherType() == DispatcherType.REQUEST) {
            ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

            Map<String, String> headers = getRequestHeaders(wrappedRequest);

            Log log = new Log();
            log.setUrl(wrappedRequest.getRequestURL().toString());
            log.setHeaders(headers.toString());
            log.setMethod(wrappedRequest.getMethod());
            log.setRequest(getRequestBody(request));

            log.setResponse("");

            if (ex == null)
                log.setStatusCode(response.getStatus());
            else {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                String sStackTrace = sw.toString();
                log.setStatusCode(500);
                log.setStackTrace(sStackTrace);
            }

            stopWatch.stop();
            log.setTimeSpent(stopWatch.getTotalTimeMillis());

            Gson gson = new Gson();

            logger.info(gson.toJson(log));
        }

        if (stopWatch.isRunning())
            stopWatch.stop();
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        String requestBody = "";

        if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        }

        return requestBody.isEmpty() ? "No request body" : requestBody;
    }

    private Map<String, String> getRequestHeaders(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }

        return headers;
    }
}