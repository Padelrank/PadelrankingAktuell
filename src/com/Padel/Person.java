package com.Padel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleIntegerProperty playerID;
    private final SimpleStringProperty playerName;
    private final SimpleIntegerProperty rankingPoints;

    public Person(int pID, String pName, int rPoints) {
        this.playerID = new SimpleIntegerProperty(pID);
        this.playerName = new SimpleStringProperty(pName);
        this.rankingPoints = new SimpleIntegerProperty(rPoints);
    }

    public int getPlayerID() {
        return playerID.get();
    }

    public void setPlayerID(int pID) {
        playerID.set(pID);
    }

    public String getPlayerName() {
        return playerName.get();
    }

    public void setPlayerName(String pName) {
        playerName.set(pName);
    }

    public int getRankingPoints() {
        return rankingPoints.get();
    }

    public void setRankingPoints(int rPoints) {
        rankingPoints.set(rPoints);
    }
}

