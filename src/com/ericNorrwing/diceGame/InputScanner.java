package com.ericNorrwing.diceGame;

import java.util.*;

public class InputScanner {
    //Initializes some values and the scanner Class
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    List<Integer> chosenDice = new ArrayList<>();

    //Ensures int input through looped statement
    public int scanInt(){
        int userInput = 0;
        while(true){
            if (scanner.hasNextInt()){
                userInput = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid input, try again");
            }
        }
        return userInput;
    }
    //Selects the amount of dice to reroll, ensures correct values
    public int selectDiceToKeep(int maxRerollCount) {
        int userInput = 0;
            userInput = scanInt();
            while (userInput < 1 || userInput > maxRerollCount){
                System.out.println("Invalid number, please try again");
                userInput = scanInt();
            }
        return userInput;
    }
    //used for instansiating dice to ensure that the values are within reason.
    public int setDiceAmount() {
        boolean tempBool = true;
        int temp;
        do {
            temp = scanInt();
            if (temp <= 0 || temp > 20) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");
            } else {
                tempBool = false;
            }
        } while (tempBool);
        return temp;
    }
    //same as above, except it checks if sides is 3 because you are creating a void in the universe with an object with 3 sides
    public int setDiceSides(){
        int temp;
        boolean tempBool = true;
        do {
            temp = scanInt();
            if (temp <= 0 || temp > 20) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");
            } else if ( temp == 3) {
                System.out.println("Theres no physical dimension for an object with 3 sides, please try again");
            } else {
                tempBool = false;
            }

        } while (tempBool);
        return temp;
    }

    //This method takes in a certain amount of dice you wish to reroll on your round, and ensures
    //that the values are within bounds and have not been previously selected before a fresh dice reroll
    public List<Integer> chooseDice (int amountOfRerolls,List<Die> diceList){;
        System.out.println("Please insert " + amountOfRerolls + " numbers: chose by picking the slot it is in (so 1 is the first number)");
            for (int i = 0; i < amountOfRerolls; i++) {
                int k = scanInt();
                while(k <= 0 || k > diceList.size()){
                    System.out.println("Value out of bounds for diceList.size()");
                    k = scanInt();
                }
                Die die = diceList.get(k-1);
                while(chosenDice.contains(k) && die.isSaved()){

                    System.out.println("This value has already been chosen or is already saved, please choose another");
                    k = scanInt();
                }
                    chosenDice.add(k);
                k = 0;
            }
        return chosenDice;
    }

    //A scanner for Strings, strings does not check anything because you can name yourself 9david#Swag if you wish
    public String scanString(){
        return scanner.next();
    }

    // Y/N boolean return function for quicker inputs and limiting bad values
    public boolean yesOrNo(){
        do {
            String temp = scanString();
            if (temp.equalsIgnoreCase("y")){
                return true;
            } else if (temp.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Please choose valid input Y or N");
            }
        } while (true);
    }

}