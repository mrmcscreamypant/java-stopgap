package dev.john.mfja.core;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.util.JMath;

public class XYPair {

    public double x, y; // I prefer to access the values directly without getters

    public XYPair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public XYPair() {
        this(0, 0);
    }

    public static XYPair setFromConsole(String name, IConsole console) {
        XYPair newPair = new XYPair(
                JMath.demandDoubleByForce(name + ".x", console),
                JMath.demandDoubleByForce(name + ".y", console)
        );
        return newPair;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public XYPair duplicate() {
        return new XYPair(this.x, this.y);
    }

    public XYPair add(XYPair value) {
        final XYPair newPair = this.duplicate();
        newPair.x += value.x;
        newPair.y += value.y;
        return newPair;
    }

    public XYPair sub(XYPair value) {
        final XYPair newPair = this.duplicate();
        newPair.x -= value.x;
        newPair.y -= value.y;
        return newPair;
    }

    public XYPair mul(double value) {
        final XYPair newPair = this.duplicate();
        newPair.x *= value;
        newPair.y *= value;
        return newPair;
    }

    public XYPair div(double value) {
        final XYPair newPair = this.duplicate();
        newPair.x /= value;
        newPair.y /= value;
        return newPair;
    }

    public double dist(XYPair other) {
        return Math.sqrt(Math.pow(this.x + other.x, 2) + Math.pow(this.y + other.y, 2));
    }
}
