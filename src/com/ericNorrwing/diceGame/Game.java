package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.List;


public class Game {

    //initialize some stuff i might move them later?

    List<Player> playerList = new ArrayList<>();
    int[] diceList = {0,0,0,0,0};
    InputScanner scanner = new InputScanner();


    //Welcome to the main game
    public void playGame(){


        //Game game = new Game();

        // new game();
        // highScore();
        // Exit();
        switch (menu()) {
            case 1:
                newGame();
                runGame();

            case 2:
                //getHighscore();
            case 3:
                //exitGame();
            default:
                System.out.println("Please enter a valid alternative. Values accepted are 1-3");
                return;

        }


        //int menuChoice  = menu.menu();



        //Runs the input put by the player, new game/highscore/exit


    }

    private int runGame(){
        for (int i = 0; i < playerList.size(); i++){
            rollNewRound();
            Player currentPlayer = playerList.get(i);
            System.out.println("Heres your dice " + currentPlayer.getName());
            printCurrentDice();
        }
        return 0;
    }
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
        //remove later, prints the players
        System.out.println(playerList.toString());


    }

    //Returns 1-6
    private int rollDice(){
        return (int)(Math.random() * 6) + 1;

    }

    private void rollNewRound(){
        for(int i = 0; i < diceList.length; i++){
            diceList[i] = rollDice();

        }
    }

    private void printCurrentDice(){
        for(int i: diceList) {
            System.out.print(i + " ");
        }
    }

    public int menu(){
        System.out.println("Welcome to the menu: Please make a choice: ");
        System.out.println("1. New Game \n2. Check highscore \n3. Exit game");

        InputScanner scanner = new InputScanner();
        return scanner.scanInt();
    }

}
