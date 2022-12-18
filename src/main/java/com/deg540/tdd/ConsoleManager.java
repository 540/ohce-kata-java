package com.deg540.tdd;

import java.util.Scanner;

public class ConsoleManager {
    private final Scanner scanner;

    public ConsoleManager() {
        this.scanner = new Scanner(System.in);
    }

    public String read(){
            return scanner.nextLine();
    }

    public void write(String sentence){
        System.out.printf("\n%s\n", sentence);
    }
}
