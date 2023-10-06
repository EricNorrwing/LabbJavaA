package com.ericNorrwing.diceGame;

import java.util.*;


public class Game {

    // TODO ORDER
    // 1# newGame();
    // 2#


    //initialize some stuff i might move them later?


    //Sets the value to end the game
    int endScore = 500;
    //My scanner class
    InputScanner scanner = new InputScanner();
    GameEngine game = new GameEngine();

    //Welcome to the main game
    public void playGame() {
        System.out.println("Welcome to the menu: Please make a choice: ");
        System.out.println("1. New Game \n2. Check highscore \n3. Exit game");

        //Runs the game through switch
        switch (scanner.scanInt()) {
            case 1 -> {
                runGame();
            }
            case 2 -> {
                // testAllTheStuff();
                // calculateScore();
            }
            //getHighscore();
            //exitGame();
            default -> {
                System.out.println("Please enter a valid alternative. Values accepted are 1-3");
                return;
            }
        }
    }
    private int runGame() {
        game.newGame();
        game.play();

        return 0;
    }
}

   /* private void checkWinner(){

        int leader = 0;
        for (Player currentPlayer : playerList) {
            if (leader < currentPlayer.getScore()) {
                leader = currentPlayer.getScore();
            }
        }
        for (Player currentPlayer : playerList) {
            if (leader == currentPlayer.getScore()) {
                System.out.println(currentPlayer.getName() + " ");
            }
        }

    }
    private boolean checkEnd(){
        for (Player currentPlayer : playerList) {
            System.out.println(currentPlayer.getScore());
            if (currentPlayer.getScore() >= endScore && checkEqualTurns()) {
                return false;
            }
        }
        return true;
    }
    private boolean checkEqualTurns() {
        int checkEndList[] = new int[playerList.size()];
        for (int i = 0; i < checkEndList.length; i++) {
            Player currentPlayer = playerList.get(i);
            checkEndList[i] = currentPlayer.getTurnsPlayed();
            if (checkEndList[0] != checkEndList[i]) {
                return false;
            }
        }
        return true;
    }
*/