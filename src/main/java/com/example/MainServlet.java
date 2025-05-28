package com.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class MainServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    @Override
    public void init() throws ServletException {
        logger.info("init servlet {}", this.getClass());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("METHOD: Get, parameter map: {}", req.getParameterMap());
        logger.info("init_par1, init parameter: {}", getServletConfig().getInitParameter("init_par1"));
        logger.info("par1, context parameter: {}", getServletContext().getInitParameter("par1"));
        final var msg = "hello, world from servlet3";
        resp.setHeader("test", "123");
        resp.addCookie(new Cookie("test", "bla_bla_bla"));
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.setContentLength(msg.getBytes(StandardCharsets.UTF_8).length);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(msg);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Post, parameter map: {}", req.getParameterMap());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Put, parameter map: {}", req.getParameterMap());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("METHOD: Delete, parameter map: {}", req.getParameterMap());
    }
}
