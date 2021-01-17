package jm.task.core.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String sql = "CREATE TABLE if not exists users " +
                "(id BIGINT not NULL, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "hbstudent", "Fpfptkm1979sql");
             Statement statement = connection.createStatement()) {
            System.out.println("Database connection successful!\n");
            statement.executeUpdate(sql);
            System.out.println("Table users create successful or already exists!");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }
}


















