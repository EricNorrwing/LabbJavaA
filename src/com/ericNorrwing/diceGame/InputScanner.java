package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int scanInt(){
        return scanner.nextInt();
    }
    public int selectHowManyDicesToReroll(int amountOfDice){
        int j = scanner.nextInt();
        boolean continueLoop = false;
        do {

            if (j < 1 || j > amountOfDice){
                System.out.println("Please choose a number between 1 and " + amountOfDice);
                j = scanner.nextInt();
            }
        }while (continueLoop);
        return j;
    }
    public int setDiceAmount() {
        boolean tempBool = true;
        int temp;
        do {
            temp = scanner.nextInt();
            if (temp <= 0 || temp >= 20) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");
            } else {
                tempBool = false;
            }
        } while (tempBool);
        return temp;
    }

    public int setDiceSides(){
        int temp;
        boolean tempBool = true;
        do {
            temp = scanner.nextInt();
            if (temp <= 0 || temp >= 20) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");
            } else if ( temp == 3) {
                System.out.println("Theres no physical dimension for an object with 3 sides, please try again");
            } else {
                tempBool = false;
            }

        } while (tempBool);
        return temp;
    }
    public List<Integer> chooseDice (int amountOfRerolls){
        List<Integer> tempList = new ArrayList<>();
        System.out.println("Please insert " + amountOfRerolls + " numbers");
            for (int i = 0; i < amountOfRerolls; i++) {
                int k = scanner.nextInt();
                tempList.add(k);
            }

        return tempList;
    }

    public String scanString(){
        return scanner.nextLine();
    }

    public void clearScanner(){
        scanner.nextLine();
    }
    public boolean yesOrNo(){
        boolean continueLoop = false;

        do {
            String temp = scanString();
            if (temp.equalsIgnoreCase("y")){
                return true;
            } else if (temp.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Please choose valid input Y or N");
                continueLoop = true;
            }

        } while (continueLoop);
        System.out.println("an error has occured");
        return true;
    }

}