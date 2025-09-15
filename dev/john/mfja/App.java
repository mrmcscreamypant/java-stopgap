package dev.john.mfja;

import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.Task;

import dev.john.mfja.tasks.SizeChecker;
import dev.john.mfja.tasks.HelloWorld;
import dev.john.mfja.tasks.LoopSpam;
import dev.john.mfja.tasks.Advent;

import java.lang.reflect.InvocationTargetException;

public class App {

    IConsole out = new CLI();

    private enum Tasks {
        SIZECHECKER(SizeChecker.class),
        HELLOWORLD(HelloWorld.class),
        LOOPSPAM(LoopSpam.class),
        ADVENT(Advent.class);

        private Task task;

        private Tasks(Class thistask) {
            try {
                this.task = (Task) thistask.getConstructors()[0].newInstance(new CLI());
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private Boolean runTask(String name) {
        for (Tasks task : Tasks.values()) {
            if (task.name().toLowerCase().equals(name)) {
                this.out.clear();
                task.task.run();
                return true;
            }
        }
        return false;
    }

    private String requestTask() {
        this.out.print("Valid tasks:");
        for (Tasks task : Tasks.values()) {
            this.out.print(" - " + task.name().toLowerCase());
        }
        final String requested = this.out.prompt("\nTask").toLowerCase();
        return requested;
    }

    private void bootstrap(String[] args) {
        String requested;
        if (args.length == 0) {
            requested = this.requestTask();
        } else {
            requested = args[0];
        }

        if (!this.runTask(requested)) {
            this.out.print("Failed to find task with name '" + requested + "'");
        }
    }
}
