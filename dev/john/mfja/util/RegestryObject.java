package dev.john.mfja.util;

public class RegestryObject<T> {
    public Class<T> child;

    public RegestryObject(Class<T> child) {
        this.child = child;
    }
}
