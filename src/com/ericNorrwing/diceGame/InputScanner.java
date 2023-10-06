package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class InputScanner {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public int scanInt(){
        return scanner.nextInt();
    }
    public int selectDiceToKeep(List<Die> diceList) {
        boolean continueLoop = false;
        int value = 0;
        do {
            value = scanInt();
            if (value < 1 || value > diceList.size()){
                System.out.println("Invalid number, please try again");
                value = scanInt();
            }


        }while(scanner.hasNextInt());

        return value;
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
            temp = scanInt();
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
        System.out.println("Please insert " + amountOfRerolls + " numbers: chose by picking the slot it is in (so 1 is the first number)");
            for (int i = 0; i < amountOfRerolls; i++) {
                int k = scanInt();

                   /*if (!rerolledDiceList.contains(k)){
                        System.out.println("Sorry this value has already been played. try another number");
                        k = scanInt();
                    }*/
                    tempList.add(k);
            }

        return tempList;
    }

    public String scanString(){
        return scanner.next();
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