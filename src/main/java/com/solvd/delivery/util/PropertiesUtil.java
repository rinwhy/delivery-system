package com.solvd.delivery.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static PropertiesUtil instance;
    private final Properties props;
    private String DB_URL;
    private String DB_USER;
    private String DB_PASS;

    private PropertiesUtil() {
        props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DB_URL = props.getProperty("db.url");
        initializeValues();
    }

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    private void initializeValues() {
        DB_URL = props.getProperty("db.url");
        DB_USER = props.getProperty("db.user");
        DB_PASS = props.getProperty("db.pass");
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }
}
