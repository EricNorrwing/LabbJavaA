package com.ericNorrwing.diceGame;

public class Player {

    String name;
    int score;
    int turnsPlayed;


    public Player(String name, int score, int id, int turnsPlayed) {
        this.name = name;
        this.score = score;
        this.turnsPlayed = turnsPlayed;
    }

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

    @Override
    public String toString() {
        return "Player:" + name + " " + score;
    }


}