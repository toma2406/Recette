package hei.devweb.javacinee.servlets;

import hei.devweb.javacinee.managers.RecetteLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/image")
public class ImageServlet extends GenericServlet {
    private Map<String, String> mimeTypes;


    public void init() throws ServletException {
        mimeTypes = new HashMap<>();
        mimeTypes.put("jpg", "image/jpeg");
        mimeTypes.put("jpeg", "image/jpeg");
        mimeTypes.put("png", "image/png");
        mimeTypes.put("gif", "image/gif");
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer recetteid =Integer.parseInt(request.getParameter("id"));
        Path imagePath = null;
        try {
            imagePath = RecetteLibrary.getInstance().getImageRecettePath(recetteid);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ;
        try {
            imagePath = RecetteLibrary.getInstance().getImageRecettePath(recetteid);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String pictureFileName = imagePath.getFileName().toString();

        String pictureFileExtension = pictureFileName.substring(pictureFileName.lastIndexOf(".") + 1);
        String contentType = mimeTypes.get(pictureFileExtension);

        response.setContentType(contentType);
        Files.copy(imagePath,response.getOutputStream());
    }
}
