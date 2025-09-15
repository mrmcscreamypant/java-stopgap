package dev.john.mfja.tasks.advent;

import dev.john.mfja.util.IConsole;
import color.Color;

public class AdventConsole {
    private IConsole out;

    public AdventConsole(IConsole out) {
        this.out = out;
    }

    private enum ColorTypes {
        SYSTEM(Color.COLOR_YELLOW);

        private final Color color;

        private ColorTypes(Color color) {
            this.color = color;
        }
    }

    private void printColor(String msg, Color color) {
        final String colorized = Color.colorize(color, msg);
        this.out.print(colorized);
    }

    public void system(String msg) {
        this.printColor(msg, ColorTypes.SYSTEM.color);
    }
}