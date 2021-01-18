package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {









        try {
            Util.initGlobalConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String sql = "CREATE TABLE if not exists users " +
                "(id BIGINT not NULL, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";





        String url = Util.getProperty("db.url");
        String user = Util.getProperty("db.user");
        String password = Util.getProperty("db.password");
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);


//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false", "hbstudent", "hbstudent");
//             Statement statement = connection.createStatement()) {
//            System.out.println("Database connection successful!\n");
//            statement.executeUpdate(sql);
//            System.out.println("Table users create successful or already exists!");
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }


        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            System.out.println("Database connection successful!\n");
            statement.executeUpdate(sql);
            System.out.println("Table users create successful or already exists!");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }
}


















