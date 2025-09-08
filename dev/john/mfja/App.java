package dev.john.mfja;

import dev.john.mfja.tasks.TaskRegestry;
import dev.john.mfja.tasks.TaskRegestryObject;
import dev.john.mfja.util.CLI;
import dev.john.mfja.util.IConsole;

public class App {

    static final IConsole out = new CLI();
    static final TaskRegestry tasks_regestry = new TaskRegestry();

    public static void main(String[] args) {
        final TaskRegestryObject task = App.tasks_regestry.items(args).get("int-size");
        out.print(String.valueOf(task.new_instance()));
    }
}
