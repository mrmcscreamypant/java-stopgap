package dev.john.mfja.core;

public class Parter implements IResponse {

    @Override
    public String transform(String name) {
        return "Goodbye, " + name + "...";
    }
}
