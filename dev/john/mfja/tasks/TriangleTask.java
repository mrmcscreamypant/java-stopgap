package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.core.Triangle;

public class TriangleTask extends Task {

    public TriangleTask(IConsole out) {
        super(out);
    }

    @Override
    public void run() {
        Triangle triangle = Triangle.setFromConsole("triangle",out);
        out.print(String.valueOf(triangle));
        out.print(String.valueOf(triangle.area()));
    }
}
