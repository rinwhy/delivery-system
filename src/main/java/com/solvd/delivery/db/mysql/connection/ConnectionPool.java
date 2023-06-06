package com.solvd.delivery.db.mysql.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    public static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);


    public static Connection getConnection()  {

        Properties props = new Properties();

        Connection connection =null;

        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            props.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.pass"));
        } catch (SQLException e) {
            LOGGER.error("Error getting the connection \n" + e.getStackTrace());
        }

        return connection;
    }


}
