package com.ericNorrwing.diceGame;

import java.util.Scanner;

public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int scanInt(){
        return scanner.nextInt();
    }

    public String scanString(){
        return scanner.nextLine();
    }

    public void clearScanner(){
        scanner.nextLine();
    }

}
