package hei.devweb.javacinee.managers;

import hei.devweb.javacinee.dao.impl.ProfilDao;
import hei.devweb.javacinee.dao.impl.ProfilDaoImpl;
import hei.devweb.javacinee.entities.Profil;

import java.util.List;

public class ProfilLibrary {

    private static class ProfilLibraryHolder {
        private final static ProfilLibrary instance = new ProfilLibrary();
    }

    public static ProfilLibrary getInstance() {
        return ProfilLibrary.ProfilLibraryHolder.instance;
    }

    private ProfilDao profilDao = new ProfilDaoImpl();


    private ProfilLibrary() {
    }

    public List<Profil> listProfil() {
        return profilDao.listProfil();
    }

    public Profil addProfil(Profil profil) {

        return profilDao.addProfil(profil);
    }

}
