package hei.devweb.javacinee.test;

import hei.devweb.javacinee.dao.impl.DataSourceProvider;
import hei.devweb.javacinee.dao.impl.RecetteDao;
import hei.devweb.javacinee.dao.impl.RecetteDaoImpl;
import hei.devweb.javacinee.entities.Recette;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Java6Assertions.tuple;


public class RecetteDaoTestCase extends AbstractDaoTestCase{
    private RecetteDaoImpl recetteDao = new RecetteDaoImpl();

        @Override
    public void insertDataSet(Statement statement) throws Exception {
        statement.executeUpdate("INSERT INTO recette(id_recette, Nom, Text, Ingredients, Difficulte, image, Type,deleted) VALUES(1, 'Nom 1', 'Text 1', 'Ingredients 1', 'Facile', null,'Plat',0)");
        statement.executeUpdate("INSERT INTO recette(id_recette, Nom, Text, Ingredients, Difficulte, image, Type,deleted) VALUES(2, 'Nom 2', 'Text 2', 'Ingredients 2', 'Difficile','c:/path/to/image.jpg' ,'Entree',0)");
        statement.executeUpdate("INSERT INTO recette(id_recette, Nom, Text, Ingredients, Difficulte, image, Type,deleted) VALUES(3, 'Nom 3', 'Text 3', 'Ingredients 3', 'Facile', null,'Desert',1)");
    }

    @Test
    public void shouldListRecette() throws Exception {
        // WHEN
        List<Recette> recettes = recetteDao.listRecettes();
        // THEN
        Assertions.assertThat(recettes).hasSize(2);
        Assertions.assertThat(recettes).extracting("id", "Nom", "Text", "Ingredients","Difficulte","Type").containsOnly(
                tuple(1, "Nom 1", "Text 1","Ingredients 1","Facile","Plat"),
                tuple(2, "Nom 2", "Text 2","Ingredients 2","Difficile","Entree")
        );
    }

    @Test
    public void shouldGetRecette() throws Exception {
        // WHEN
        Recette recette = recetteDao.getRecette(1);
        // THEN
        Assertions.assertThat(recette).isNotNull();
        Assertions.assertThat(recette.getId()).isEqualTo(1);
        Assertions.assertThat(recette.getNom()).isEqualTo("Nom 1");
        Assertions.assertThat(recette.getText()).isEqualTo("Text 1");
        Assertions.assertThat(recette.getIngredients()).isEqualTo("Ingredients 1");
        Assertions.assertThat(recette.getDifficulte()).isEqualTo("Facile");
        Assertions.assertThat(recette.getType()).isEqualTo("Plat");
        Assertions.assertThat(recette.getDeleted()).isEqualTo(0);
    }

    @Test
    public void shouldNotGetDeletedRecette() {
        // WHEN
        Recette recette = recetteDao.getRecette(3);
        // THEN
        Assertions.assertThat(recette).isNull();
    }


    @Test
    public void shouldGetImagePath() {
        // WHEN
        Path imagePath = recetteDao.getImagePath(2);
        // THEN
        Assertions.assertThat(imagePath).isNotNull();
        Assertions.assertThat(imagePath).isEqualTo(Paths.get("c:/path/to/image.jpg"));
    }


    @Test
    public void shouldNotGetImagePathIfNonExistant() {
        // WHEN
        Path imagePath = recetteDao.getImagePath(1);
        // THEN
        Assertions.assertThat(imagePath).isNull();
    }

    @Test
    public void shouldAddRecette() throws Exception {
        // GIVEN
        Recette newRecette = new Recette(null, "Ma recette","Mon Text", "Mes ingredients","Ma difficulte", "Mon type",0);
        // WHEN
        recetteDao.addRecette(newRecette, Paths.get("C:/test/to/image.jpg"));
        // THEN
        try(Connection connection = DataSourceProvider.getDaraSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recette WHERE Nom='Ma recette'")){
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getInt("id_recette")).isNotNull();
            Assertions.assertThat(resultSet.getString("Nom")).isEqualTo("Ma recette");
            Assertions.assertThat(resultSet.getString("Text")).isEqualTo("Mon Text");
            Assertions.assertThat(resultSet.getString("Ingredients")).isEqualTo("Mes ingredients");
            Assertions.assertThat(resultSet.getString("Difficulte")).isEqualTo("Ma difficulte");
            Assertions.assertThat(resultSet.getInt("deleted")).isEqualTo(0);
            Assertions.assertThat(resultSet.getString("image")).isEqualTo("C:\\test\\to\\image.jpg");
            Assertions.assertThat(resultSet.next()).isFalse();
        }
    }

    @Test
    public void shouldAddRecetteNoImage() throws Exception {
        // GIVEN
        Recette newRecette = new Recette(null, "Ma recette","Mon Text", "Mes ingredients","Ma difficulte", "Mon type",0);
        // WHEN
        recetteDao.addRecette(newRecette,null);
        // THEN
        try(Connection connection = DataSourceProvider.getDaraSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recette WHERE Nom='Ma recette'")){
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getInt("id_recette")).isNotNull();
            Assertions.assertThat(resultSet.getString("Nom")).isEqualTo("Ma recette");
            Assertions.assertThat(resultSet.getString("Text")).isEqualTo("Mon Text");
            Assertions.assertThat(resultSet.getString("Ingredients")).isEqualTo("Mes ingredients");
            Assertions.assertThat(resultSet.getString("Difficulte")).isEqualTo("Ma difficulte");
            Assertions.assertThat(resultSet.getInt("deleted")).isEqualTo(0);
            Assertions.assertThat(resultSet.next()).isFalse();
        }
    }

    @Test
    public void shouldDeleteRecette() throws SQLException {
        // WHEN
        recetteDao.deleteRecette(2);
        // THEN
        try(Connection connection = DataSourceProvider.getDaraSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM recette WHERE id_recette=2")){
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getBoolean("deleted")).isTrue();
            Assertions.assertThat(resultSet.next()).isFalse();
        }
    }






}


