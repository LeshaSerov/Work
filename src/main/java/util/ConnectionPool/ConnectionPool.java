package util.ConnectionPool;

import jakarta.annotation.Resource;
import jakarta.ejb.Init;
import util.configuration.PropertyReader;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.init();
        String url = propertyReader.getUrl();
        String user = propertyReader.getUser();
        String password = propertyReader.getPassword();
        return DriverManager.getConnection(url, user, password);

    }
}