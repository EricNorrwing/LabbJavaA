package com.ericNorrwing.diceGame.diceFunctions;

public class Dice {
    int dice = 0;
    int[] diceArray = {0,0,0,0,0};


    private static int rollDice(){
        return (int)(Math.random() * 6) + 1;

    }

    public int getDiceArray(){
        return rollDice();
    }


}










