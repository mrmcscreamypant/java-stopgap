package dev.john.mfja.util;

import java.util.Scanner;

public class CLI implements IConsole {
    private final Scanner scanner;

    public final CLI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public final void print(String msg, Boolean newline) {
        if (newline) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

    @Override
    public final void print(String msg) {
        this.print(msg, true);
    }

    @Override
    public final String prompt(String msg) {
        this.print(msg + ": ", false);

        return this.scanner.nextLine();
    }
}
