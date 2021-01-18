package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException{

        User user1 = new User("Вася","Пупкинг", (byte) 25);
        UserDaoJDBCImpl t = new UserDaoJDBCImpl();
        t.dropUsersTable();
        t.createUsersTable();

        t.saveUser("Вася",
                "Пупкинг",
                (byte) 25);
        t.dropUsersTable();









    }
}


















