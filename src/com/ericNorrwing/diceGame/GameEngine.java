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
    //list of dices that was rerolled last asking
    List<Die> rerolledDice = new ArrayList<>();
    //HashMap of all unique values and the amount of occurances, used for calculating score
    Map<Integer, Integer> allDiceOccurances = new HashMap<>();
    //Hashmap of all unique values in the rerolled dice list, used for calculating if you scored points
    Map<Integer, Integer> newRollDiceOccurances = new HashMap<>();

    //instantiates the "InputScanner" class
    InputScanner scanner = new InputScanner();

    //Selects a point at which the game checks for winners
    int endScore = 0;

    //This is the general gameplay loop that runs once a game has been initialized
    protected void play(){
        int totalpot = 0;
        int currentPot = 0;
        int rerolledPot = 0;
        do {
            for (Player currentPlayer : playerList) {
                //Start the loop here
                do {
                    System.out.println("Heres your dice " + currentPlayer.getName());
                    printCurrentDice();
                    if (checkScore(allDiceOccurances, diceList) == 0) {
                        System.out.println("You scored no point and the turn passes");
                        totalpot = 0;
                        initializeDiceListValues(diceList);
                        break;
                    }
                    System.out.println("the total pot is: " + totalpot);
                    //If player wants to continue
                    System.out.println("Do you wish to continue playing, Y/N");
                    if (!scanner.yesOrNo()) {
                        break;
                    }

                    rerolledPot = keepDice(newRollDiceOccurances, rerolledDice);
                    if (checkIfAllDiceAreRerolled(diceList)){
                        resetDice(diceList);
                        initializeDiceListValues(diceList);
                          totalpot = totalpot +  checkScore(allDiceOccurances, diceList);
                    }
                    updateMap();
                    if (rerolledPot == 0) {
                        break;
                    }

                    //If all dices are rerolled, save the current pot and start fresh dice

                    // TODO
                } while (true);
                currentPlayer.setScore(currentPlayer.getScore()+currentPot+totalpot);

            }
        }while (checkEnd()) ;
        System.out.println("And the winners are: ");
        checkWinner();
    }

    //a simple return of all dices that are not status "saved"
    protected int availableDiceForReroll(){
        int value = 0;
        for (Die die: diceList){
            if (!die.isSaved()){
                value++;
            }
        }
        return value;
    }
    //method checking if all dices have been rerolled, used for setting up a fresh list of dice
    private boolean checkIfAllDiceAreRerolled(List<Die> diceList) {
        for (Die die : diceList) {
            if (!die.isSaved()) {
                return false; // If any die is not saved, return false
            }
        }
        return true; // If all dice are saved, return true
    }
    //Checks who won the game, after the loop has ended
    private void checkWinner(){
        int leader = 0;
        for (Player currentPlayer : playerList) {
            if (leader < currentPlayer.getScore()) {
                leader = currentPlayer.getScore();
            }
        }
        for (Player currentPlayer : playerList) {
            if (leader == currentPlayer.getScore()) {
                System.out.printf("%s with %d score %n", currentPlayer.getName(), currentPlayer.getScore());
            }
        }
    }
    //Checks if it should end the loop because someone reached the correct criteras
    private boolean checkEnd() {
        for (Player currentPlayer : playerList) {
            System.out.println(currentPlayer.getScore());
            if (currentPlayer.getScore() >= endScore && checkEqualTurns()) {
                return false;
            }
        }
        return true;
    }
    //Checks if everyone has played an even amount of turns so that nobody gets cheated
    private boolean checkEqualTurns() {
        int[] checkEndList = new int[playerList.size()];
        for (int i = 0; i < checkEndList.length; i++) {
            Player currentPlayer = playerList.get(i);
            checkEndList[i] = currentPlayer.getTurnsPlayed();
            if (checkEndList[0] != checkEndList[i]) {
                return false;
            }
        }
        return true;
    }

    //returns an int signifying the amount of score based off which dice and map was sent to the method
    private int keepDice(Map<Integer, Integer> newRollDiceOccurances, List<Die> rerolledDices){
        System.out.println("Please choose the amount of dice to keep");
        List<Integer> rerollableDice = scanner.chooseDice(scanner.selectDiceToKeep(availableDiceForReroll()),diceList);
        System.out.println("Which dice do you wish to keep? enter the values and enter between each");
        for (int i: rerollableDice){
            Die die = diceList.get(i-1);
            die.setSaved(true);
        }

        for (Die die: diceList){

            if (!die.isSaved()){
                die.setValue(rollDice());
                rerolledDices.add(die);
                newRollDiceOccurances.put(die.getValue(),0);
            }

        }

        return checkScore(newRollDiceOccurances, rerolledDices);

    }
    //clears the current allDiceOccurances map so that it does not add values once dice is rerolled
    private void updateMap(){
        allDiceOccurances.clear();
        checkScore(allDiceOccurances, diceList);
    }
    //Randomizes a value between 1 and diceSides (As listed in the Die class)
    public int rollDice(){
        Die die = diceList.get(0);
        return (int)(Math.random() * die.getSides()) + 1;
    }
    //returns the score value of the current dice in diceList
    private int checkScore(Map<Integer, Integer> source,List<Die> dices){
        return initializeOccurances(source,dices);
    }
    //initializes map so that calculate score can use it
    private int initializeOccurances(Map<Integer,Integer> source, List<Die> dices){
        int incrementValue = 0;
        //Puts ALL the values from diceList<> as keys in map
        for (Die die : dices) {
            source.put(die.getValue(), incrementValue);
        }
        /*
        Iterates through DiceList again, for every value it then digs up the map.get(i) list
        saves the value, increments it, and adds it back.
        This means it saves the amount of occurrences of each die in the map.
        */
        for (Die die: dices){
            incrementValue = source.get(die.getValue());
            incrementValue++;
            source.put(die.getValue(), incrementValue);
        }

        return calculateScore(source);
    }
    //Checks the score of the current DiceList
    private int calculateScore(Map<Integer,Integer> source){
        int score = 0;
        for (int i: source.keySet()){
            if (source.get(i)>= 3){
                int scoreMultiplier = source.get(i)-3;
                if (i == 1) {
                    score = score + 1000*(int)Math.pow(2,scoreMultiplier);

                } else {
                    score = score + i * 100*(int)Math.pow(2,scoreMultiplier);

                }

            } else if (i == 1){
                score = score + 100* source.get(i);
            } else if (i == 5) {
                score = score + 50* source.get(i);
            }
        }
        return score;
    }
    private void printCurrentDice(){
        for(Die die: diceList) {
            System.out.print(die.getValue() + " ");
        }
        System.out.println("\n");
        System.out.println("The current dice is worth: " + checkScore(allDiceOccurances,diceList));
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
                "(Recommended is 6, but values accepted are 1-20) " + "\n" +
                "and how many sides does the dice have?(Recommended is 6)  ");
        createDice(scanner.setDiceAmount(), scanner.setDiceSides());
        System.out.println("At what score does the game end? (Offical rules is 10 000, recommend 500~ for testing");
        endScore = scanner.scanInt();
        resetDice(diceList);
        initializeDiceListValues(diceList);

    }
    //Creates new Die to fill up DiceList
    public void createDice(int amount, int sides){
        for (int i = 0; i < amount; i++){
            diceList.add(new Die(0, sides));
        }

    }
    //Resets the diceList by making all values 0
    private void resetDice(List<Die> diceList){
        //Resets diceList
        for (Die d: diceList) {
            d.setValue(0);
            d.setSaved(false);
        }
    }
    //Sets new random values in diceList
    public void initializeDiceListValues(List<Die> diceList){
        for (Die die : diceList) {
            die.setValue(rollDice());
        }
    }

}
