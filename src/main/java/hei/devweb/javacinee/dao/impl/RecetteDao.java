package hei.devweb.javacinee.dao.impl;


import hei.devweb.javacinee.entities.Recette;
import org.omg.CORBA.INTERNAL;

import java.nio.file.Path;
import java.util.List;

public interface RecetteDao {

    public  List<Recette> listRecettes();

    public Recette getRecette(Integer id);

    public Recette addRecette(Recette recette, Path picturepath);

    public void deleteRecette(Integer id);

    public Path getImagePath(Integer recetteid);


    }


