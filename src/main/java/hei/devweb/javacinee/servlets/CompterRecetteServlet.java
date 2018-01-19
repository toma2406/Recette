package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.managers.RecetteLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CompterRecette")
public class CompterRecetteServlet extends GenericServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            int nbRecettes = RecetteLibrary.getInstance().compterRecette();
            PrintWriter out = response.getWriter();
            out.append(String.valueOf(nbRecettes));
    }
}
