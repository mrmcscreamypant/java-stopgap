package dev.john.mfja;

import dev.john.mfja.core.Greeter;
import dev.john.mfja.core.IResponse;
import dev.john.mfja.core.SizeChecker;
import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.Task;

public class App {

    IConsole out = new CLI();

    private enum Tasks {
        SIZECHECKER(SizeChecker.class);//,
        //GREETER(Greeter.class);

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

        public Tasks[] getTasks() {
            return this.values();
        }
    }

    public static void main(String[] args) {
        App workaround = new App();
        workaround.bootstrap(args);
    }

    private void bootstrap(String[] args) {
        for (Tasks task : Tasks.values()) {
            this.out.print(task.name());
        }
    }

}
