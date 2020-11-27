package com.Padel;

public class User {


    private String fName;
    private String eName;
    private String userName;
    private String eMail;
    private String location;
    private String password;
    private int rank, matches;
    private double score;


    User(String fName, String eName, String eMail, String userName,  String password) {
        this.fName = fName;
        this.eName = eName;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
        welcomeMail();
    }

    private void addToDatabase(User user){

    }

    void welcomeMail() {

    }
}
