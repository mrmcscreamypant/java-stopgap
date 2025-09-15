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

    public void system(String msg) {
        final String colorized = Color.colorize(ColorTypes.SYSTEM.color, msg);
        this.out.print(colorized);
    }
}