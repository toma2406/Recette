package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.RecetteLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/Modifier")
@MultipartConfig
public class ModifierServlet extends GenericServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Nom =request.getParameter("Nom");
        String Text=request.getParameter("Text");
        String Ingredients=request.getParameter("Ingredients");
        String Difficulte=request.getParameter("Difficulte");
        String Type=request.getParameter("Type");

        Integer deleted=0;

        Part image =request.getPart("image");

        Integer recetteid= Integer.parseInt(request.getParameter("id"));
        String idrecette = request.getParameter("id");
        int id = Integer.parseInt(idrecette);

        RecetteLibrary.getInstance().deleteRecette(recetteid);

        Recette newRecette= new Recette(recetteid,Nom, Text, Ingredients, Difficulte,Type,deleted);
        RecetteLibrary.getInstance().addRecette(newRecette,image);

        response.sendRedirect("/plat");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer recetteid= Integer.parseInt(request.getParameter("id"));
        String idrecette = request.getParameter("id");
        int id = Integer.parseInt(idrecette);


        RecetteLibrary.getInstance().getRecette(id);
        WebContext context = new WebContext(request, response, request.getServletContext());
        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        context.setVariable("recette",RecetteLibrary.getInstance().getRecette(recetteid));
        templateEngine.process("ModifierUneRecette", context, response.getWriter());
    }
}
