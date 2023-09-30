package com.ericNorrwing.diceGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int scanInt(){
        return scanner.nextInt();
    }

    //This function is extremely picky, please make sure to not input too many numbers or outside of index as its input is a String
    public List<Integer> chooseDice (int j){
        List<Integer> tempList = new ArrayList<Integer>();
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