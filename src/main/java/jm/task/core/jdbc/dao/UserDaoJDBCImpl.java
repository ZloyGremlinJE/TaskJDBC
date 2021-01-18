package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.getConnection();
        System.out.println("Database connection successful!");
    }

    public void createUsersTable() {
        String CREATE_TABLE = "CREATE TABLE if not exists users " +
                "(id BIGINT not NULL AUTO_INCREMENT, " +
                " name VARCHAR(70), " +
                " lastName VARCHAR(70), " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE);
            System.out.println("Table users create successful or already exists!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Table users is delete!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String INSERT = "INSERT INTO users VALUES(id,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User: " +
                    name + "/" +
                    lastName +
                    "/" +
                    age +
                    " added to db!");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
