package com.Padel;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnector{

    static Connection conn;

    public Connection connector() {
        try {
            Class.forName("org.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padelrank?useTimezone=true&serverTimezone=UTC", "root", "123");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
