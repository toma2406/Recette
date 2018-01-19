package hei.devweb.javacinee.dao.impl;

import javax.activation.DataHandler;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {
    private static MysqlDataSource dataSource;

    public static MysqlDataSource getDaraSource(){
        if (dataSource == null){
            dataSource = new MysqlDataSource();
            dataSource.setServerName ("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("projet-personnel");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }
        return dataSource;
    }

}
