package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEngine{
    //List of all current players
    List<Player> playerList = new ArrayList<>();
    //List of current dice in the round
    List<Die> diceList = new ArrayList<>();
    //HashMap of all unique values and the amount of occurances, used for calculating score
    Map<Integer, Integer> map = new HashMap<>();

    InputScanner scanner = new InputScanner();

    int endScore = 0;


    protected void play(){
        int currentPot = 0;
        int rerolledPot = 0;
        boolean continuePlaying;
        for (Player currentPlayer : playerList) {
            //Start the loop here
            do{
                System.out.println("Heres your dice " + currentPlayer.getName());
                printCurrentDice();
                currentPot = checkScore();

                //If player wants to continue
                System.out.println("Do you wish to continue playing, Y/N");
                continuePlaying = passTurn(currentPot, rerolledPot, scanner.yesOrNo());

                keepDice();
                System.out.println(diceList);


            }while(currentPot > 0 || rerolledPot > 0 || !continuePlaying);


            System.out.println("Do you wish to continue trying to play? Y to continue, N to retain points and pass turn");
            //scanner.clearScanner();
            continuePlaying = scanner.yesOrNo();


        }
    }









    private void keepDice(){
        System.out.println("Please choose the amount of dice to keep");
        List<Integer> rerollableDice = scanner.chooseDice(scanner.selectDiceToKeep(diceList));
        System.out.println("Which dice do you wish to keep? (Chose items in the list, seperator is space");
        for (int i: rerollableDice){
            Die die = diceList.get(i-1);
            die.setSaved(true);
        }

        for (Die die: diceList){
            if (!die.isSaved()){
                die.setValue(rollDice());
            }
        }

    }

    private int rollDice(){
        Die die = diceList.get(0);
        return (int)(Math.random() * die.getSides()) + 1;
    }
    private boolean passTurn(int currentPot, int rerolledPot, boolean continueLoop){
        return currentPot < 0 || rerolledPot < 0 && continueLoop;
    }
    //returns the score value of the current dice in diceList
    private int checkScore(){
        initializesMap();
        return calculateScore();
    }
    //initializes map so that calculate score can use it
    private void initializesMap(){

        int incrementValue = 0;
        //Puts ALL the values from diceList<> as keys in map
        for (int i = 0; i < diceList.toArray().length; i++){
            Die die = diceList.get(i);
            map.put(die.getValue(), incrementValue);
        }
        /*
        Iterates through DiceList again, for every value it then digs up the map.get(i) list
        saves the value, increments it, and adds it back.
        This means it saves the amount of occurrences of each die in the map.
        */
        for (Die die: diceList){
            incrementValue = map.get(die.getValue());
            incrementValue++;
            map.put(die.getValue(), incrementValue);
        }
    }
    //Checks the score of the current DiceList
    private int calculateScore(){
        int score = 0;
        for (int i: map.keySet()){
            if (map.get(i)>= 3){
                int scoreMultiplier = map.get(i)-3;
                if (i == 1) {
                    score = score + 1000*(int)Math.pow(2,scoreMultiplier);

                } else {
                    score = score + i * 100*(int)Math.pow(2,scoreMultiplier);

                }

            } else if (i == 1){
                score = score + 100*map.get(i);
            } else if (i == 5) {
                score = score + 50*map.get(i);
            }
        }
        // TODO - Remove maybe?
        System.out.println(score);
        return score;
    }
    private void printCurrentDice(){
        for(Die die: diceList) {
            System.out.print(die.getValue() + " ");
        }
        System.out.println("\n");
    }
    //Initializes Players/Die and puts them in lists
    public void newGame(){
        System.out.println("Hello, how many would like to play?");
        int j = scanner.scanInt();
        for (int i = 0; i < j; i++ ){
            //This if() only ensures that the scanner empties on future loops
            System.out.println("Enter player:" + (i+1) + " name");
            Player player = new Player(scanner.scanString(), 0,0,0);
            playerList.add(player);

        }
        System.out.println("How many dice would you like to use?" +
                "(Recommended is 6, but values accepted are 1-20) " +
                "and how many sides does the dice have?(Recommended is 6)  ");
        createDice(scanner.setDiceAmount(), scanner.setDiceSides());
        System.out.println("At what score does the game end? (Offical rules is 10 000, recommend 500~ for testing");
        endScore = scanner.scanInt();
        resetDice(diceList);
        initializeDiceListValues(diceList);

    }
    //Creates new Die to fill up DiceList
    private void createDice(int amount, int sides){
        for (int i = 0; i < amount; i++){
            diceList.add(new Die(0, sides));
        }

    }
    //Resets the diceList by making all values 0
    private void resetDice(List<Die> diceList){
        //Resets diceList when new round begins
        for (Die d: diceList) {
            d.setValue(0);
            d.setSaved(false);
        }
    }
    //Sets new random values in diceList
    private void initializeDiceListValues(List<Die> diceList){
        for (int i = 0; i < diceList.size(); i++){
            Die die = diceList.get(i);
            die.setValue(rollDice());
        }
    }

}
