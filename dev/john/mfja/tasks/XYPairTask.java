package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.core.XYPair;

public class XYPairTask extends Task {
    public XYPairTask(IConsole out) {
        super(out);
    }

    @Override
    public void run() {
        final XYPair firstPoint = XYPair.setFromConsole("firstPoint", out);
        final XYPair secondPoint = XYPair.setFromConsole("secondPoint", out);
        final XYPair thirdPoint = new XYPair(2.2,3.1);

        out.print("First point: "+firstPoint);
        out.print("Second point: "+secondPoint);
        out.print("Third point for good measure: "+thirdPoint);

        out.print("Distance between "+firstPoint+" and "+secondPoint+": "+firstPoint.dist(secondPoint));
        out.print("Slope between "+secondPoint+" and "+thirdPoint+": "+secondPoint.slope(thirdPoint));
        out.print("Equation through "+thirdPoint+" and "+firstPoint+": "+thirdPoint.equation(firstPoint));
    }
}