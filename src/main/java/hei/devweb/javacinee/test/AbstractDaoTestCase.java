package hei.devweb.javacinee.test;

import hei.devweb.javacinee.dao.impl.DataSourceProvider;
import org.junit.Before;

import java.sql.Connection;
import java.sql.Statement;

public abstract class AbstractDaoTestCase {
    @Before
    public void initDatabase() throws Exception {
        try(
                Connection connection = DataSourceProvider.getDaraSource().getConnection();
                Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM recette");

            this.insertDataSet(statement);
        }
    }

    public abstract void insertDataSet(Statement statement) throws Exception;
}
