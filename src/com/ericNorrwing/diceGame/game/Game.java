package com.ericNorrwing.diceGame.game;

import com.ericNorrwing.diceGame.menu.Menu;
import com.ericNorrwing.diceGame.scanner.InputScanner;
import com.ericNorrwing.diceGame.playerFunctions.Player;
import java.util.ArrayList;


public class Game {
    //Welcome to the main game
    public static void playGame(){
        Menu menu = new Menu();
        Game game = new Game();

        System.out.println("Welcome to the game!");
        //Runs the input put by the player, new game/highscore/exit
        menu.menu();

    }

    //Just make a new method to put new objects into arraylist. No need for the "addPlayer" function
    public static void newGame(){
        System.out.println("Hello, how many would like to play? ");
        InputScanner scanner = new InputScanner();
        for (int i = 0; i < scanner.scanInt()+1; i++ ){
            Player player = new Player(scanner.scanString(), 0,0,0);
            player.addPlayer(scanner.scanInt());

            System.out.println("Player added");
        }

    }
}
