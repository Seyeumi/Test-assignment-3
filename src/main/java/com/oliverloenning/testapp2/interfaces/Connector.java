package com.oliverloenning.testapp2.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Connector {
    static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "test";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            System.out.println("You did not connect to the database");
        }
        return con;
    }
}
