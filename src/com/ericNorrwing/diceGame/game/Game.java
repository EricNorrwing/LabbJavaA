package com.ericNorrwing.diceGame.game;

import com.ericNorrwing.diceGame.menu.Menu;
import com.ericNorrwing.diceGame.playerFunctions.Player;
import com.ericNorrwing.diceGame.scanner.InputScanner;

public class Game {

    //Welcome to the main game
    public static void playGame(){
        Menu menu = new Menu();
        Game game = new Game();
        System.out.println("Welcome to the game!");
        int choice = menu.menu();


    }

    public void newGame(){
        System.out.println("Hello, how many would like to play? ");
        InputScanner scanner = new InputScanner();
        for (int i = 0; i < scanner.scanInt()+1; i++ ){
            Player player = new Player(scanner.scanString(), 0);

            System.out.println("Player added");
        }

    }
}
