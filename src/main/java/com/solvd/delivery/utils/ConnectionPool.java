package com.solvd.delivery.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ConnectionPool {

    public static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;

    private final int POOL_SIZE = 10;
    private final List<Connection> pool;
    private final BlockingQueue<Connection> poolQueue;       // available connections within the pool

    private ConnectionPool() {
        pool = new ArrayList<>(POOL_SIZE);
        poolQueue = new ArrayBlockingQueue<>(POOL_SIZE);
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection requestConnection() {

        if (poolQueue.isEmpty() && pool.size() < POOL_SIZE) {
            PropertiesUtil props = PropertiesUtil.getInstance();
            Connection newConnection = null;
            try {
                newConnection = DriverManager.getConnection(props.getDB_URL(), props.getDB_USER(), props.getDB_PASS());
            } catch (SQLException e) {
                LOGGER.error("Error getting the connection \n" + e.getMessage());
            }
            pool.add(newConnection);
            poolQueue.add(newConnection);
        }
        return getConnection();
    }


    private Connection getConnection() {
        try {
            return poolQueue.poll(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("\nInterrupted Exception" + e.getMessage());
        }
        return null;
    }

    public synchronized void releaseConnection(Connection connection) {
        poolQueue.add(connection);
    }
}
