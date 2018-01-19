package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.RecetteLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.w3c.dom.css.Rect;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.soap.SAAJResult;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajouterUneRecette")
@MultipartConfig
public class AjouterServlet extends GenericServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        templateEngine.process("AjouterUneRecette", context, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Nom =req.getParameter("Nom");
        String Text=req.getParameter("Text");
        String Ingredients=req.getParameter("Ingredients");
        String Difficulte=req.getParameter("Difficulte");
        String Type=req.getParameter("Type");
        Integer deleted=0;

        Part image =req.getPart("image");

        Recette newRecette= new Recette(null, Nom, Text, Ingredients, Difficulte,Type,deleted);
        RecetteLibrary.getInstance().addRecette(newRecette,image);
        resp.sendRedirect("/plat");

        }
        }
