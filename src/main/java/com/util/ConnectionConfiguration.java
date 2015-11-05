package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by manishatri on 5/11/15.
 */
public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DeliveryApp", "root", "");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}


