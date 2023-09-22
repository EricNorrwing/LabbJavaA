package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.List;


public class Game {

    //initialize some stuff i might move them later?

    List<Object> playerList = new ArrayList<>();
    int dice = 0;
    InputScanner scanner = new InputScanner();


    //Welcome to the main game
    public void playGame(){
        Menu menu = new Menu();
        Game game = new Game();

        int menuChoice  = menu.menu();



        //Runs the input put by the player, new game/highscore/exit


    }

    //Just make a new method to put new objects into arraylist. No need for the "addPlayer" function
    public void newGame(){
        System.out.println("Hello, how many would like to play?");
        int j = scanner.scanInt();
        for (int i = 0; i < j; i++ ){
            //This if() only ensures that the scanner empties on future loops
            if(i == 0){
                scanner.clearScanner();
            }
                System.out.println("Enter player:" + (i+1) + " name");
                Player player = new Player(scanner.scanString(), 0,0,0);
                playerList.add(player);


        }
        System.out.println(playerList.toString());


    }

    //Returns 1-6
    private int rollDice(){
        return (int)(Math.random() * 6) + 1;

    }

}
