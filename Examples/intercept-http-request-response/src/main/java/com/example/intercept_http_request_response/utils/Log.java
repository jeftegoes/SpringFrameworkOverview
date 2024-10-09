package com.example.intercept_http_request_response.utils;

public class Log {
    private String url;
    private String headers;
    private String method;
    private String request;
    private String response;
    private int statusCode;
    private float timeSpent;
    private String stackTrace;

    public Log() {

    }

    public Log(String url, String headers, String method, String request, String response, int statusCode, float timeSpent) {
        this.url = url;
        this.headers = headers;
        this.method = method;
        this.request = request;
        this.response = response;
        this.statusCode = statusCode;
        this.timeSpent = timeSpent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public float getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(float timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
