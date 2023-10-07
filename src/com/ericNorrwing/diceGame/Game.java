package com.ericNorrwing.diceGame;

import java.util.*;


public class Game {

    //Sets the value to end the game
    int endScore = 500;
    //My scanner class
    InputScanner scanner = new InputScanner();
    GameEngine game = new GameEngine();

    //Welcome to the main game
    public void playGame() {
        System.out.println("Welcome to the menu: Please make a choice: ");
        System.out.println("1. New Game \n2. Check highscore \n3. Exit game");

        //Runs a simple menu to start game or exit
        switch (scanner.scanInt()) {
            case 1 -> {
                runGame();
            }
            case 2 ->{
                System.exit(0);
            }
            default -> {
                System.out.println("Please enter a valid alternative. Values accepted are 1-3");
            }
        }
    }

    //The actual game runs here, to ensure that the game is fresh if the first choice is selected again
    private void runGame() {
        game.newGame();
        game.play();
    }
}

