package com.ericNorrwing.diceGame;

public class Player {

    String name;
    int score;
    int id;
    int turnsPlayed;


    public Player(String name, int score, int id, int turnsPlayed) {
        this.name = name;
        this.score = score;
        this.id = id;
        this.turnsPlayed = turnsPlayed;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Player:" + name + " " + score;
    }


}
