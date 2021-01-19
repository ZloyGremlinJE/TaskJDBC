package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Вася", "Пупкинг", (byte) 25);
        service.saveUser("Коля", "Декстер", (byte) 21);
        service.saveUser("Элтон", "Пресли", (byte) 29);
        service.saveUser("Обама", "Трамп", (byte) 23);

        List<User> list = service.getAllUsers();
        System.out.println(list);
        service.removeUserById(1);
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}


















