package com.Padel;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLConn {
    //C:\Users\46760\Documents\GitHub\Ppadelranking
      //      C:\Users\46760\Documents\GitHub
    //C:\Users\46760\Documents\GitHub\Ppadelranking\PadelrankingAktuell
    //C:\Users\46760\Documents\GitHub\Ppadelranking\PadelrankingAktuell\src\com\Padel\dbCred.properties

    public static Connection DbConnector(){
        try{
            Databaseinit db = new Databaseinit();

            db.init("C:\\Users\\46760\\Documents\\GitHub\\Ppadelranking\\PadelrankingAktuell\\src\\com\\Padel\\dbCred.properties");
            Connection conn = null;
            conn = db.getConnection();
            return conn;
        } catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }


}
