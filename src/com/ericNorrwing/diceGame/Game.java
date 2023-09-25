package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.List;


public class Game {

    //initialize some stuff i might move them later?

    List<Player> playerList = new ArrayList<>();
    int[] diceList = {0,0,0,0,0,0};
    InputScanner scanner = new InputScanner();
    final int ARRAY_LIST_REROLL = -1;

    //Welcome to the main game
    public void playGame(){
        System.out.println("Welcome to the menu: Please make a choice: ");
        System.out.println("1. New Game \n2. Check highscore \n3. Exit game");

        //Game game = new Game();

        // new game();
        // highScore();
        // Exit();
        switch (scanner.scanInt()) {
            case 1:
                newGame();
                runGame();
                break;
            case 2:
                testAllTheStuff();
                break;
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
            checkScore();
            if (checkIfDiceScored()){
                System.out.println("Which dice would you like to keep? Current score is : ");
            } else {
                System.out.println("You didnt score any points");
            }

        }
        return 0;
    }
    private int checkScore(){
        checkMultiples();
        //checkOnes();
        //checkFives();
        return 0;
    }
    private int checkMultiples(){
        int score = 0;
        int dupeCounter = 0;
        int diceDupeValue = 0;
            for (int i = 0; i < diceList.length; i++) {
                int firstDiceCheck = diceList[i];
                for (int j = 0; j < diceList.length; j++) {
                    if (i == j) {
                        System.out.println("im in the i is J loop");
                        continue;
                    }else{
                        int secondDiceCheck = diceList[j];
                        if (firstDiceCheck == secondDiceCheck) {
                            System.out.println("youre in loop " + i);
                            diceDupeValue = firstDiceCheck;
                            dupeCounter++;
                    }


                    }
                }
            }
        if(dupeCounter >= 3){
            System.out.println(dupeCounter);
            System.out.println("Dice dupe value is " + diceDupeValue);
        }
        return score;
    }
    private boolean checkIfDiceScored(){
        for (int i = 0; i < diceList.length; i++){
            if(diceList[i] == 1 || diceList[i] == 5){
                System.out.println("You scored something");
                return true;
            }
            else{
                System.out.println("You didnt score");
                return false;

            }
        }
        System.out.println("this is an error code");
        return false;
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
        System.out.println("\n");
    }
    private void testAllTheStuff(){
        rollNewRound();
        printCurrentDice();
        checkScore();
        System.out.println("lmao testing shit");
    }

}
