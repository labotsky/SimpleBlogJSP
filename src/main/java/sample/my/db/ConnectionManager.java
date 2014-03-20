package sample.my.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 20.03.14.
 */
public class ConnectionManager {
    private String url;
    private String user;
    private String password;
    private String dbName;
    private Map<String, Connection> connectionMap = new HashMap<String, Connection>();

    /**
     *
     * @param url
     * @param user
     * @param password
     */
    public ConnectionManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        System.out.println("url: " + url);
    }

    /**
     * Return connection by current thread.
     * @return
     */
    public Connection getConnection(){
        String key = Thread.currentThread().getName();
        Connection connection = connectionMap.get(key);
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url, user, password);
                connectionMap.put(key, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * return DB name
     * @return
     */
    public String getDbName(){
        return dbName;
    }
}
