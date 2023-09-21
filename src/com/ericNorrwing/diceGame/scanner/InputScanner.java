package com.ericNorrwing.diceGame.scanner;

import java.util.Scanner;

public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int scanInt(){
        return scanner.nextInt();
    }

    public String scanString(){
        return scanner.nextLine();
    }
}
