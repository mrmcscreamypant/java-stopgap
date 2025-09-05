package dev.john.mfja;

import dev.john.mfja.core.Greeter;
import dev.john.mfja.core.IResponse;
import dev.john.mfja.core.Parter;
import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;

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

        final String hello = this.responder.transform(name);

        out.print(hello);

        final String goodbye = new Parter().transform(name);
        out.print(goodbye);

        int small = 0;
        int last = 0;
        while (true) {
            small += 1;
            if (small < last) {
                break;
            }
            last = small;
        }

        out.print("Found int max size (" + String.valueOf(last) + " bits)");
        out.print("(I'm not quite crazy enough to do doubles)");
    }

}
