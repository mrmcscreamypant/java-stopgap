package dev.john.mfja.util;

public class CLI implements IConsole {

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

        final java.util.Scanner in = new java.util.Scanner(System.in);
        return in.next();
    }
}
