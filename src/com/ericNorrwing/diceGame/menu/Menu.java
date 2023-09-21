package com.ericNorrwing.diceGame.menu;

import com.ericNorrwing.diceGame.game.Game;
import com.ericNorrwing.diceGame.scanner.InputScanner;
import com.ericNorrwing.diceGame.playerFunctions.Player;

import java.util.Scanner;

public class Menu {

    public int menu(){
        System.out.println("Welcome to the menu: Please make a choice: ");
        System.out.println("1. New Game \n2. Check highscore \n3. Exit game");

        InputScanner scanner = new InputScanner();
        int choice = scanner.scanInt();

        //Standard menu choices
        switch (choice) {
            case 1:
                Game.newGame();
                Game.playGame();
                return choice;
            case 2:
                //getHighscore();
                return choice;
            case 3:
                //exitGame();
                return choice;
            default:
                System.out.println("Please enter a valid alternative. Values accepted are 1-3");
                return 0;

        }


    }

}
