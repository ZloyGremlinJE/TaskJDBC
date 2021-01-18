package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        UserDaoJDBCImpl t = new UserDaoJDBCImpl();
        t.createUsersTable();
        t.dropUsersTable();









    }
}


















