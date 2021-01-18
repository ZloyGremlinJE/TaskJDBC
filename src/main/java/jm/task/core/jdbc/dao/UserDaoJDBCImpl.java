package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final String CREATE_TABLE = "CREATE TABLE if not exists users " +
            "(id BIGINT not NULL AUTO_INCREMENT, " +
            " name VARCHAR(70), " +
            " lastName VARCHAR(70), " +
            " age TINYINT, " +
            " PRIMARY KEY ( id ))";

    Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.getConnection();
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            System.out.println("Database connection successful!\n");
            statement.executeUpdate(CREATE_TABLE);
            System.out.println("Table users create successful or already exists!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try(  Statement statement = connection.createStatement())  {

            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Table users is delete");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
