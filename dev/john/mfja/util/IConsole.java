package dev.john.mfja.util;

public interface IConsole {

    public void print(String msg, Boolean newline);

    public void print(String msg);

    public String prompt(String msg);

    public String prompt(String msg, boolean formated);

    public void clear();

    public void sleep(int seconds);
}
