package dev.john.mfja.core;

import java.util.ArrayList;

import dev.john.mfja.util.IConsole;

public class Triangle {

    ArrayList<XYPair> verts = new ArrayList<>();

    public Triangle(XYPair v1, XYPair v2, XYPair v3) {
        this.verts.add(v1);
        this.verts.add(v2);
        this.verts.add(v3);
    }

    @Override
    public String toString() {
        return "Triangle(" + this.verts.toString() + ")";
    }

    public static Triangle setFromConsole(String name, IConsole out) {
        return new Triangle(
                XYPair.setFromConsole(name + ".vertex1", out),
                XYPair.setFromConsole(name + ".vertex2", out),
                XYPair.setFromConsole(name + ".vertex3", out)
        );
    }

    public double area() {
        final ArrayList<Double> dists = new ArrayList<>();
        for (int idx = 0; idx < this.verts.size(); idx++) {
            XYPair vert = this.verts.get(idx);
            dists.add(vert.dist(this.verts.get(Math.floorMod(idx, this.verts.size()))));
        }
        double s = 0;
        for (double dist : dists) {
            s += dist;
        }
        s /= 2;
        double q = 1;
        for (double dist : dists) {
            q *= (s - dist);
        }

        return Math.sqrt(s * q);
    }
}
