package dev.john.mfja.tasks.advent;

import dev.john.mfja.util.IConsole;
import color.Color;

public class AdventConsole {
    private IConsole out;

    public AdventConsole(IConsole out) {
        this.out = out;
    }

    public void system(String msg) {
        final String colorized = Color.colorize(COLOR_RED, msg);
        this.out.print(colorized);
    }
}