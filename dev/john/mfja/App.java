package dev.john.mfja;

import dev.john.mfja.core.Greeter;
import dev.john.mfja.core.IResponse;
import dev.john.mfja.core.SizeChecker;
import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;

public class App {

    IConsole out = new CLI();
    IResponse responder = new Greeter();
    SizeChecker checker = new SizeChecker(out);

    private enum task {
        SIZECHECKER(new SizeChecker(out))
    }

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private void bootstrap(String[] args) {
        this.out.print(String.valueOf(foo.values()));
    }

}
