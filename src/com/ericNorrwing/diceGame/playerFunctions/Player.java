package com.ericNorrwing.diceGame.playerFunctions;

import com.ericNorrwing.diceGame.scanner.InputScanner;

public class Player {

    String name;
    int score;
    int id;
    int turnsPlayed;


    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addPlayers(int inputPlayerAmount){
        for (int i = 0; i < inputPlayerAmount; i++){
            System.out.println("Hello please insert a name for player: " + (i+1));
            InputScanner scanner = new InputScanner();

        }
    }
}
