package com.askoura.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Launcher {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9898);

        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");

        ServletHolder servletHolder = new ServletHolder(new DefaultServlet() {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setStatus(HttpServletResponse.SC_OK);
            }
        });

        servletContextHandler.addServlet(servletHolder, "/");

        server.setHandler(servletContextHandler);

//        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(servletContextHandler));

        server.start();
//        server.join();
    }
}
