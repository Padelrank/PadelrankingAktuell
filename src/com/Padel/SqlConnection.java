package com.Padel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection{

    public static Connection DbConnector(){
        try{
            Connection conn = null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padelrank?useTimezone=true&serverTimezone=UTC", "root", "123");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
