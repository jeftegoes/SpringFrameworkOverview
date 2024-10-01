package com.example.intercept_http_request_response.handlers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Interceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        registerLog(request, null);

        return true;
    }

    public void registerLog(HttpServletRequest request, Exception ex) throws IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        String url = wrappedRequest.getRequestURL().toString();
        String method = wrappedRequest.getMethod();

        String requestBody = "";

        if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        }

        Map<String, String> headers = getRequestHeaders(wrappedRequest);
        if (ex != null)
            logger.info("Request URL: {}, Method: {}, Headers: {}, Request Body: {}, Início StackTrace: {} Fim StackTrace", url, method, headers, getRequestBody(requestBody), ex.getStackTrace().toString();
        else
            logger.info("Request URL: {}, Method: {}, Headers: {}, Request Body: {}", url, method, headers, getRequestBody(requestBody));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        registerLog(request, ex);

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private String getRequestBody(String request) {
        return request.isEmpty() ? "No request body" : request;
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