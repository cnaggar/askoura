package com.askoura.library;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.askoura.library.config.SpringMVC;

public class Launcher {

    private Server server;
    private AnnotationConfigWebApplicationContext webApplicationContext;

    public static void main(String[] args) throws Exception {
        new Launcher().start(args);
    }

    public void start(String[] args) throws Exception {
        // Instantiating Spring MVC
        webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.setConfigLocation(SpringMVC.class.getPackage().getName());

        // Wiring Spring with Jetty
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(webApplicationContext));

        // Servlet context creation
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/");

        // Running Jetty
        server = new Server(9898);
        server.setHandler(servletContextHandler);

        server.start();
    }
    
    public void stop() throws Exception {
        server.stop();
        webApplicationContext.close();
    }
}
