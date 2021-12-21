package com.MainControl;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectionDB {

    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String driverManager = "jdbc:mysql://localhost/books";

    private static Connection connection = null;

    public static void connect() {
        try {
            Class.forName(jdbcDriver);
            connection = (Connection) DriverManager.getConnection(driverManager, DatabaseLoginUser.getRoot(), DatabaseLoginUser.getPassword());
            System.out.println("jdbc driver has connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error with jdbc driver");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}



