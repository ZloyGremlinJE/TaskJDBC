package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilderImpl implements ConnectionBuilder {



    @Override
    public Connection getConnection() throws SQLException {
        String url = Util.getProperty("db.url");
        String login = Util.getProperty("db.user");
        String password = Util.getProperty("db.password");
        return DriverManager.getConnection(url, login, password);
    }
}
