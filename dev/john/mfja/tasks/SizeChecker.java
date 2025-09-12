package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;

public class SizeChecker extends Task {
    public SizeChecker(IConsole out) {
        super(out);
    }

    @Override
    public void run() {
        int small = 0;
        int last = 0;
        while (true) {
            small += 1;
            if (small < last) {
                break;
            }
            last = small;
        }

        this.out.print("Found int max size (" + String.valueOf(last) + " bits)");
        this.out.print("(I'm not quite crazy enough to do doubles)");
    }
}