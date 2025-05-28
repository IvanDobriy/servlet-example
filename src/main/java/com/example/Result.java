package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

public class Result {
    private Map<String, String> headers;
    private Map<String, String[]> parameters;
    private Map<String, String> servletConfig;
    private Map<String, String> applicationConfig;
    private String uri;
    private String method;
    private String body;

    public Result(){
        headers = new HashMap<>();
        parameters = new HashMap<>();
        servletConfig = new HashMap<>();
        applicationConfig = new HashMap<>();
        uri = "";
        method = "";
        body = "";
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String[]> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String[]> parameters) {
        this.parameters = parameters;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getServletConfig() {
        return servletConfig;
    }

    public void setServletConfig(Map<String, String> servletConfig) {
        this.servletConfig = servletConfig;
    }

    public Map<String, String> getApplicationConfig() {
        return applicationConfig;
    }

    public void setApplicationConfig(Map<String, String> applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
