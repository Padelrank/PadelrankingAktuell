package com.Padel;

import java.util.LinkedList;
import java.util.List;

public class PlayerList {
    List<Person> players = new LinkedList<>();

    PlayerList(Person e){
        players.add(e);
    }

}
