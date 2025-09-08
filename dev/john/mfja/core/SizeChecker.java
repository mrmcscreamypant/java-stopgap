package dev.john.mfja.core;

import dev.john.mfja.tasks.ITask;
import dev.john.mfja.util.IConsole;

public class SizeChecker implements ITask{

    private final IConsole out;

    public SizeChecker(IConsole out) {
        this.out = out;
    }
    
    public static SizeChecker builder(IConsole out) {
        return new SizeChecker(out);
    }

    @Override
    public void bootstrap() {
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
