package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;

interface ITask {
    public void run();
}

public abstract class Task implements ITask {
    public IConsole out;

    public Task(IConsole out) {
        this.out = out;
    }
}