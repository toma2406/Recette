package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.RecetteLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/plat")
public class PlatServlet extends GenericServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        List<Recette> recettes= RecetteLibrary.getInstance().listRecettes();
        context.setVariable("recettesList",recettes);
        templateEngine.process("Plat", context, response.getWriter());
    }
}
