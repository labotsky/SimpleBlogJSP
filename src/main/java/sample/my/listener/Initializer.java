package sample.my.listener;

import sample.my.constant.Attributes;
import sample.my.db.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Сергей on 20.03.14.
 */
class Initializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        File config = new File(servletContextEvent.getServletContext().getRealPath("/WEB-INF/connection-config.properties"));
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = properties.getProperty("driver.class");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("connection.url");
        String user = properties.getProperty("database.user");
        String password = properties.getProperty("database.password");
        ConnectionManager manager = new ConnectionManager(url, user, password);
        servletContextEvent.getServletContext().setAttribute(Attributes.CONNECTION_MANAGER, manager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
