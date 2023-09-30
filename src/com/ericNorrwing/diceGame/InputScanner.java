package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int scanInt(){
        return scanner.nextInt();
    }
    public int setDiceAmount(){
        int temp = scanner.nextInt();
        boolean tempBool = true;
        do {
            if (temp <= 0 || temp >= 20) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");

            } else {
                tempBool = false;
            }
        } while (tempBool);
        return temp;
    }

    public int setDiceSides(){
        int temp = 0;
        boolean tempBool = true;
        do {
            temp = scanner.nextInt();
            if (temp <= 0 || temp >= 20 || temp == 3) {
                System.out.println("That value is outside bounds, please chose a value between 1-20");
                temp = scanner.nextInt();
            } else {
                tempBool = false;
            }

        } while (tempBool);
        return temp;
    }
    //This function is extremely picky, please make sure to not input too many numbers or outside of index as its input is a String
    public List<Integer> chooseDice (int j){
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < j; i++){
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

}