
import com.mfja.CLI;

public class App {

    CLI cli = new CLI();

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private String greet(String name) {
        return "Hello, "+name+"!";
    }

    private void bootstrap(String[] args) {
        for (String arg : args) {
            cli.print("Program got arg '" + arg + "'!");
        }

        final String name = cli.prompt("What is your name");

        cli.print(this.greet(name));
    }

}
