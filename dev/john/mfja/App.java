package dev.john.mfja;

import dev.john.mfja.core.Greeter;
import dev.john.mfja.core.IResponse;
import dev.john.mfja.util.IConsole;
import dev.john.mfja.util.CLI;

public class App {

    IConsole out = new CLI();
    IResponse responder = new Greeter();

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private void bootstrap(String[] args) {
        for (String arg : args) {
            out.print("Program got arg '" + arg + "'!");
        }

        final String name = out.prompt("What is your name");

        final String response = this.responder.transform(name);

        out.print(response);
    }

}
