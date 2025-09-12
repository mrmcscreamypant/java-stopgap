package dev.john.mfja.util;

import java.util.Scanner;

public class CLI implements IConsole {
    private final Scanner scanner;

    public CLI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String msg, Boolean newline) {
        if (newline) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

    @Override
    public void print(String msg) {
        this.print(msg, true);
    }

    @Override
    public String prompt(String msg) {
        this.print(msg + ": ", false);

        return this.scanner.nextLine();
    }

    @Override
    public void clear() {
        this.print("\033[H\033[2J");   
        //System.out.flush();  
    }
}
