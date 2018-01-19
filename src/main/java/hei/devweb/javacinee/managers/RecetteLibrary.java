package hei.devweb.javacinee.managers;


import hei.devweb.javacinee.dao.impl.ProfilDao;
import hei.devweb.javacinee.dao.impl.ProfilDaoImpl;
import hei.devweb.javacinee.dao.impl.RecetteDao;
import hei.devweb.javacinee.dao.impl.RecetteDaoImpl;
import hei.devweb.javacinee.entities.Recette;
import hei.devweb.javacinee.entities.Profil;

import hei.devweb.javacinee.entities.Recette;

import javax.servlet.http.Part;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecetteLibrary {

	private static final String image_directory_path ="C:/Users/thomas/Desktop/Cours ITI/DevWeb/ProjetPersonnel";


	private static class RecetteLibraryHolder {
		private final static RecetteLibrary instance = new RecetteLibrary();
	}
	
	public static RecetteLibrary getInstance() {
		return RecetteLibraryHolder.instance;
	}

	private RecetteDao recetteDao = new RecetteDaoImpl();


	private RecetteLibrary() {
	}

	public List<Recette> listRecettes() {
		return recetteDao.listRecettes();
	}

	public Recette getRecette(Integer id) {
		return recetteDao.getRecette(id);
	}


	public  Recette addRecette(Recette recette, Part image) throws IOException {
		Path picturepath=null;
		if (image !=null){
			picturepath = Paths.get(image_directory_path,image.getSubmittedFileName());
			Files.copy(image.getInputStream(),picturepath);
		}

		return recetteDao.addRecette(recette,picturepath);
	}

	public void  deleteRecette(Integer id){
		recetteDao.deleteRecette(id);

	}


	public Path getImageRecettePath (Integer recetteid) throws URISyntaxException {
		Path imagePath=recetteDao.getImagePath(recetteid);
		if (imagePath ==null){
			imagePath= Paths.get(this.getClass().getClassLoader().getResource("repas.jpg").toURI());
		}
		return imagePath;
	}

	public Integer compterRecette() {
		return recetteDao.listRecettes().size();
	}


}
