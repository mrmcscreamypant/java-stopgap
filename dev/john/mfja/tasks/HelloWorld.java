package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.core.IResponse;
import dev.john.mfja.core.Greeter;
import dev.john.mfja.core.Parter;

public class HelloWorld extends Task {

    private final Greeter greeter = new Greeter();
    private final Parter parter = new Parter();

    public HelloWorld(IConsole out) {
        super(out);
    }

    private final void respond(IResponse responder, String name) {
        this.out.print(responder.transform(name));
    }

    @Override
    public void run() {
        final String name = this.out.prompt("What is your name");
        this.respond(this.greeter, name);
        this.respond(this.parter, name);
    }
}
