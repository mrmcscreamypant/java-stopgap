package dev.john.mfja.util;

public class CLI {

    public final void print(String msg, boolean newline) {
        if (newline) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

    public final void print(String msg) {
        this.print(msg, true);
    }

    public String prompt(String msg) {
        this.print(msg + ": ", false);

        final java.util.Scanner in = new java.util.Scanner(System.in);
        return in.next();
    }
}
