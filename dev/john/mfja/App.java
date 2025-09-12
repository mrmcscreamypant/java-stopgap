package dev.john.mfja;

import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.Task;

import dev.john.mfja.tasks.SizeChecker;
import dev.john.mfja.tasks.HelloWorld;

public class App {

    IConsole out = new CLI();

    private enum Tasks {
        SIZECHECKER(SizeChecker.class),
        HELLOWORLD(HelloWorld.class);

        private Task task;

        private Tasks(Class thistask) {
            try {
                this.task = (Task) thistask.getConstructors()[0].newInstance(new CLI());
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        public Task getTask() {
            return task;
        }
    }

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private void bootstrap(String[] args) {
        this.out.print("Valid tasks:");
        for (Tasks task : Tasks.values()) {
            this.out.print(" - " + task.name().toLowerCase());
        }
        final String requested = this.out.prompt("\nTask").toLowerCase();

        for (Tasks task : Tasks.values()) {
            if (task.name().toLowerCase().equals(requested)) {
                task.task.run();
                return;
            }
        }

        this.out.print("Failed to find task with name '" + requested + "'");
    }

}
