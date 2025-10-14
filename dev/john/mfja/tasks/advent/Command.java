package dev.john.mfja.tasks.advent;

public abstract class Command {
    public final AdventConsole console;

    public Command(AdventConsole console) {
        this.console = console;
    }

    public abstract void run(String[] args);
}