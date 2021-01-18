package jm.task.core.jdbc.dao;

public class ConnectionFactory {
    public static ConnectionBuilder getConnectionBuilder() {
        return new ConnectionBuilderImpl();
    }

}
