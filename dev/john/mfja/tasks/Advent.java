package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.advent.AdventConsole;

public class Advent extends Task {
    private final String intro = "* ADVENT *\nA text adventure game.";
    public final AdventConsole console;

    public Advent(IConsole out) {
        super(out);
        this.console = new AdventConsole(out);
    }

    @Override
    public void run() {
        this.console.system(this.intro);
    }
}
