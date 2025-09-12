package dev.john.mfja.util;

public interface IConsole { 

    public void print(String msg, Boolean newline);

    public void print(String msg);

    public String prompt(String msg);

    public void clear();
}
