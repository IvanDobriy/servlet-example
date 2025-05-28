package com.example;


import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class MainServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    private final Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        logger.info("init servlet {}", this.getClass());
    }

    private void logic(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final var result = new Result();

        final var servletConfig = new HashMap<String, String>();
        getServletConfig().getInitParameterNames().asIterator().forEachRemaining((name) -> {
            servletConfig.put(name, getServletConfig().getInitParameter(name));
        });

        final var applicationConfig = new HashMap<String, String>();
        getServletContext().getInitParameterNames().asIterator().forEachRemaining((name) -> {
            applicationConfig.put(name, getServletContext().getInitParameter(name));
        });


        final var headersMap = new HashMap<String, String>();
        req.getHeaderNames().asIterator().forEachRemaining((headerName) -> {
            headersMap.put(headerName, req.getHeader(headerName));
        });


        logger.info("content length: {}", req.getContentLength());
        final var bodyBuilder = new byte[req.getContentLength()];
        final var reader = req.getInputStream();

        int character;
        int counter = 0;
        while ((character = reader.read()) != -1) {
            bodyBuilder[counter] = (byte) character;
            counter++;
        }
        result.setMethod(req.getMethod());
        result.setUri(req.getRequestURI());
        result.setHeaders(headersMap);
        result.setParameters(req.getParameterMap());
        if (counter > 0) {
            result.setBody(new String(bodyBuilder));
        }
        result.setServletConfig(servletConfig);
        result.setApplicationConfig(applicationConfig);


        resp.setContentType("application/json");
        resp.setHeader("test", "123");
        resp.addCookie(new Cookie("test", "bla_bla_bla"));


        final var msg = gson.toJson(result).getBytes(Charset.defaultCharset());
        resp.setContentLength(msg.length);
        final var outputStream = resp.getOutputStream();
        outputStream.write(msg);
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("METHOD: GET, uri: {}", req.getRequestURI());
        logic(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Post, parameter map: {}", req.getParameterMap());
        logic(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Put, parameter map: {}", req.getParameterMap());
        logic(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Delete, parameter map: {}", req.getParameterMap());
        logic(req, resp);
    }
}
