package server_core;

import handlers.Handlers;
import jakarta.servlet.DispatcherType;
import jetty_db.DBCon;
import jetty_db.Product;
import login_roles.PrivilegeHandler;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.DoSFilter;
import org.eclipse.jetty.util.resource.Resource;
import java.net.URL;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws Exception {


        Server server = new DefaultServer().build(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        final DoSFilter filter = new DoSFilter();
        final FilterHolder filterHolder = new FilterHolder(filter);
        final URL resource = LoginService.class.getResource("/static/");

        final String hashConfig = Main.class.getResource("/hashConfig").toExternalForm();
        final HashLoginService hashLoginService = new HashLoginService("login", hashConfig);
        final ConstraintSecurityHandler securityHandler = new PrivilegeHandler().build(hashLoginService);
        HandlerCollection collection = Handlers.getHandlers();
        filterHolder.setInitParameter("maxRequestSpec","1");
        context.addFilter(filterHolder,"/*", EnumSet.of(DispatcherType.REQUEST));
        context.setContextPath("/");
        context.setBaseResource(Resource.newResource(resource.toExternalForm()));
        context.setWelcomeFiles(new String[]{"/static/index.html"});
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");
        server.addBean(hashConfig);
        securityHandler.setHandler(context);
        collection.addHandler(securityHandler);
        server.setHandler(collection);
        server.start();
    }
}

