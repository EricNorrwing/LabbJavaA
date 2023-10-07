package com.ericNorrwing.diceGame;

public class Player {

    String name;
    int score;
    int turnsPlayed;


    //Constructor for players
    public Player(String name, int score, int id, int turnsPlayed) {
        this.name = name;
        this.score = score;
        this.turnsPlayed = turnsPlayed;
    }

    //Getters/setters for player values
    public String getName(){
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTurnsPlayed() {
        return turnsPlayed;
    }

    public void setTurnsPlayed(int turnsPlayed) {
        this.turnsPlayed = turnsPlayed;
    }

    public int getScore() {
        return score;
    }

    //Override to make printing players easier
    @Override
    public String toString() {
        return "Player:" + name + " " + score;
    }


}