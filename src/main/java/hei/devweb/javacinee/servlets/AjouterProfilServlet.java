package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Profil;
import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.ProfilLibrary;
import hei.devweb.javacinee.managers.RecetteLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajouterProfil")
public class AjouterProfilServlet extends GenericServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
            WebContext context = new WebContext(request, response, request.getServletContext());
            templateEngine.process("AjouterProfil", context, response.getWriter());

        }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Prenom=req.getParameter("Prenom");
        String Nom=req.getParameter("Nom");
        Integer Age = Integer.parseInt(req.getParameter("Age"));
        String Ecole=req.getParameter("Ecole");
        String Pseudo=req.getParameter("Pseudo");

        Profil newProfil= new Profil(null,Prenom,Nom,Age,Ecole,Pseudo);
        ProfilLibrary.getInstance().addProfil(newProfil);
        resp.sendRedirect("/profil-Etudiant");

    }

}

