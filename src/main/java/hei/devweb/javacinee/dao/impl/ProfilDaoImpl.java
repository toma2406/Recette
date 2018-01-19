package hei.devweb.javacinee.dao.impl;

import hei.devweb.javacinee.entities.Profil;
import hei.devweb.javacinee.entities.Recette;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfilDaoImpl implements ProfilDao {

    public List<Profil> listProfil() {
        String query = "SELECT * FROM profil;";
        List<Profil> listOfProfils= new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDaraSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                listOfProfils.add(new Profil(resultSet.getInt("id_profil"),resultSet.getString("Prenom"),resultSet.getString("Nom"),resultSet.getInt("Age"),resultSet.getString("Ecole"),resultSet.getString("Pseudo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfProfils;
    }

    @Override
    public Profil addProfil(Profil profil) {
        String query = "INSERT INTO profil(Prenom, Nom, Pseudo,Age,Ecole) VALUES(?,?,?,?,?);";
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,profil.getPrenom());
            statement.setString(2,profil.getNom());
            statement.setString(3,profil.getPseudo());
            statement.setInt(4,profil.getAge());
            statement.setString(5,profil.getEcole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profil;

    }

    public void deleteRecette(Integer id_recette) {
        String query = "UPDATE recette SET deleted=true WHERE id_recette=?";
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id_recette);
            statement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

}
