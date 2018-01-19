package hei.devweb.javacinee.dao.impl;

import hei.devweb.javacinee.entities.Profil;

import java.util.List;

public interface ProfilDao {
    public List<Profil> listProfil();

    public Profil addProfil (Profil profil);


}
