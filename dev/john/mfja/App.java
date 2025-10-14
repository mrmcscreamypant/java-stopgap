package dev.john.mfja;

import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.Task;

import dev.john.mfja.tasks.SizeChecker;
import dev.john.mfja.tasks.HelloWorld;
import dev.john.mfja.tasks.LoopSpam;
import dev.john.mfja.tasks.Advent;
import dev.john.mfja.tasks.TriangleTask;

import java.lang.reflect.InvocationTargetException;

public class App {

    static IConsole out = new CLI();

    private enum Tasks {
        SIZECHECKER(SizeChecker.class),
        HELLOWORLD(HelloWorld.class),
        LOOPSPAM(LoopSpam.class),
        ADVENT(Advent.class),
        TRIANGLE(TriangleTask.class);

        private Task task;

        private Tasks(Class thistask) {
            try {
                this.task = (Task) thistask.getConstructors()[0].newInstance(out);
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
                App.out.clear();
                task.task.run();
                return true;
            }
        }
        return false;
    }

    private String requestTask() {
        App.out.print("Valid tasks:");
        for (Tasks task : Tasks.values()) {
            App.out.print(" - " + task.name().toLowerCase());
        }
        final String requested = App.out.prompt("\nTask").toLowerCase();
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
            App.out.print("Failed to find task with name '" + requested + "'");
        }
    }
}
