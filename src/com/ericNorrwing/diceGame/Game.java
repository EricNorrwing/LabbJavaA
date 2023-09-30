package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Game {

    //initialize some stuff i might move them later?
    //List of all current players
    List<Player> playerList = new ArrayList<>();
    //List of current dice in the round
    List<Integer> diceList = new ArrayList<>();
    List<Integer> diceReRandom = new ArrayList<Integer>();
    //HashMap of all unique values and the amount of occurances, used for calculating score
    Map<Integer, Integer> map = new HashMap<>();
    //Amount of dice rolled per round
    int amountOfDice = 0;
    //How many sides each die has
    int diceSides = 0;
    int currentPot = 0;
    //Sets the value to end the game
    int endScore = 0;
    //My scanner class
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
                calculateScore();
                break;
            //getHighscore();
            case 3:
                //exitGame();
            default:
                System.out.println("Please enter a valid alternative. Values accepted are 1-3");
                return;

        }
    }

    private int runGame(){
        diceList.clear();
        rollNewRound();
        playRound();

        return 0;
    }
    private void playRound(){
        for (int i = 0; i < playerList.size(); i++) {
            Player currentPlayer = playerList.get(i);
            System.out.println("Heres your dice " + currentPlayer.getName());
            printCurrentDice();
            currentPot = currentPot + checkScore();
            if (currentPot >= 0) {
                System.out.println("Current pot is: " + currentPot);
                System.out.println("How many Die would you like to reroll?: ");
                int amountOfRerolls = scanner.scanInt();
                diceReRandom = scanner.chooseDice(amountOfRerolls);
                rerollDie();
                printCurrentDice();
                System.out.println(currentPot);
            } else {
                System.out.println("You didnt score any points, the pot has been reset");
                currentPot = 0;
            }
        }
    }

    private void rerollDie(){
        for (int i = 0; i < diceReRandom.size(); i++){
            int j = diceReRandom.get(i)-1;
            diceList.set(j,ARRAY_LIST_REROLL);

        }

        for (int i = 0; i < diceList.size(); i++){
            int temp = diceList.get(i);
            if (temp == -1){
                diceList.set(i,rollDice());
            }
        }
    }
    private int checkScore(){
        checkMultiples();
        return calculateScore();
    }
    private void checkMultiples(){
        int incrementValue = 0;
        //Puts ALL the values from diceList<> as keys in map
        for (int i = 0; i < diceList.toArray().length; i++){
            map.put(diceList.get(i),incrementValue);
        }
        /*
        Iterates through DiceList again, for every value it then digs up the map.get(i) list
        saves the value, increments it, and adds it back.
        This means it saves the amount of occurrences of each die in the map.
        */
        for (int i: diceList){
            incrementValue = map.get(i);
            incrementValue++;
            map.put(i, incrementValue);
        }
    }

    private int calculateScore(){
        int score = 0;
        int currentDie = 0;
        for (int i: map.keySet()){
            currentDie = i;
            if (map.get(i)>= 3){
                int scoreMultiplier = map.get(i)-3;
                if (i == 1) {
                    score = score + 1000*(int)Math.pow(2,scoreMultiplier);

                } else {
                    score = score + currentDie * 100*(int)Math.pow(2,scoreMultiplier);

                }

            } else if (currentDie == 1){
                score = score + 100*map.get(i);
            } else if (currentDie == 5) {
                score = score + 50*map.get(i);
            }
        }
        System.out.println(score);
        return score;
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
        System.out.println("How many dice would you like to use? (Recommended is 6, but values accepted are 1-20):  ");
        amountOfDice = scanner.setDiceAmount();
        System.out.println("How many sides does each die have?");
        diceSides = scanner.setDiceSides();
    }

    //Returns 1-6
    private int rollDice(){
        return (int)(Math.random() * diceSides) + 1;

    }

    private void rollNewRound(){
        for(int i = 0; i < amountOfDice; i++){
            diceList.add(rollDice());

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
        //scanner.chooseDice();
    }

}
