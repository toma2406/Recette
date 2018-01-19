package hei.devweb.javacinee.dao.impl;

import hei.devweb.javacinee.entities.Recette;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDaoImpl implements RecetteDao{

    public List<Recette> listRecettes() {
            String query = "SELECT * FROM recette WHERE NOT deleted;";
            List<Recette> listOfRecettes= new ArrayList<>();
            try (
                    Connection connection = DataSourceProvider.getDaraSource().getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query)
            ) {
                while (resultSet.next()) {
                    listOfRecettes.add(new Recette(resultSet.getInt("id_recette"),resultSet.getString("Nom"),resultSet.getString("Text"),resultSet.getString("Ingredients"),resultSet.getString("Difficulte"),resultSet.getString("Type"),resultSet.getInt("deleted")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listOfRecettes;
        }

    public Recette addRecette(Recette recette, Path picturepath) {
        String query = "INSERT INTO recette(Nom, Text, Ingredients, Difficulte,Type,image ) VALUES(?,?,?,?,?,?);";
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,recette.getNom());
            statement.setString(2,recette.getText());
            statement.setString(3,recette.getIngredients());
            statement.setString(4,recette.getDifficulte());
            statement.setString(5,recette.getType());
            if (picturepath!=null){
                statement.setString(6,picturepath.toString());
            }else {
                statement.setNull(6, Types.VARCHAR);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recette;
    }


    public Path getImagePath(Integer recetteid){
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT image FROM recette WHERE id_recette = ? AND deleted=FALSE ")) {
            statement.setInt(1, recetteid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String imagePath= resultSet.getString("image");
                    if (imagePath!=null){
                        return Paths.get(imagePath);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public Recette getRecette(Integer id) {
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM recette WHERE id_recette = ? AND deleted=false")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Recette(
                            resultSet.getInt("id_recette"),
                            resultSet.getString("Nom"),
                            resultSet.getString("Text"),
                            resultSet.getString("Ingredients"),
                            resultSet.getString("Difficulte"),
                            resultSet.getString("Type"),
                            resultSet.getInt("deleted")
                            );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void deleteRecette(Integer id) {
        String query = "UPDATE recette SET deleted=true WHERE id_recette=?";
        try (Connection connection = DataSourceProvider.getDaraSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,id );
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
