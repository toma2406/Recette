package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Profil;
import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.ProfilLibrary;
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

@WebServlet("/profil-Etudiant")
public class ProfilServlet extends GenericServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        List<Profil> profils= ProfilLibrary.getInstance().listProfil();
        context.setVariable("profilsList",profils);
        templateEngine.process("Profil-Etudiant", context, response.getWriter());
    }
}
