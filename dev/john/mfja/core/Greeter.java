package dev.john.mfja.core;

public final class Greeter implements IResponse {

    @Override
    public String transform(String name) {
        return "Hello, " + name + "!";
    }
}
