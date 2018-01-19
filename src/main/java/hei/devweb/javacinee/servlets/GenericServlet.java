package hei.devweb.javacinee.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public abstract class GenericServlet extends HttpServlet {
    protected TemplateEngine createTemplateEngine(ServletContext servletContext){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setPrefix("WEB-INF/templates/");
        templateResolver.setSuffix(".html");


        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        return templateEngine;

    }
}
