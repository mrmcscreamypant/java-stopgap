package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;

public abstract class Task {
    public IConsole out;

    public Task(IConsole out) {
        this.out = out;
    }

    public abstract void run();
}