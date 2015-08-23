package com.askoura.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.askoura.library.config.SpringMVC;

public class Launcher {

    public static void main(String[] args) throws Exception {
        
        // Instantiating Spring MVC
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(SpringMVC.class.getPackage().getName());

        // Wiring Spring with Jetty
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(context));

        // Servlet context creation
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/");

        // Running Jetty
        Server server = new Server(9898);
        server.setHandler(servletContextHandler);

        server.start();
    }
}
