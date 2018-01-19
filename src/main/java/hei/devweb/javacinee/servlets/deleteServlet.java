package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.managers.RecetteLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class deleteServlet extends GenericServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer recetteid= Integer.parseInt(request.getParameter("id"));
        String idrecette = request.getParameter("id");
        int id = Integer.parseInt(idrecette);


       String confirm = request.getParameter("confirm");
        if((confirm != null && Boolean.parseBoolean(confirm))) {
            RecetteLibrary.getInstance().deleteRecette(id);
            response.sendRedirect("/plat");
            return;
        }

        WebContext context = new WebContext(request, response, request.getServletContext());
        TemplateEngine templateEngine = createTemplateEngine(request.getServletContext());
        context.setVariable("recette",RecetteLibrary.getInstance().getRecette(recetteid));
        templateEngine.process("delete", context, response.getWriter());
    }
}
