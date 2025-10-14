package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.tasks.advent.Command;
import dev.john.mfja.tasks.advent.AdventConsole;

import java.lang.reflect.InvocationTargetException;

import dev.john.mfja.tasks.advent.commands.*;

public class Advent extends Task {

    private final String intro = "* ADVENT *\nA text adventure game.";
    public static AdventConsole console;

    private final String[] tmp_args = {"20", "40"};

    public static void bindCLI(IConsole cli) {
        console = new AdventConsole(cli);
    }

    public Advent(IConsole out) {
        super(out);
        bindCLI(out);
    }

    enum CommandRegestry {
        HELP(HelpCommand.class);

        public Command command;

        private CommandRegestry(Class command) {
            try {
                this.command = (Command) command.getConstructors()[0].newInstance(console);
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException e) {
                e.printStackTrace(System.out);
                System.exit(-1);
            }
        }
    }

    @Override
    public void run() {
        console.system(this.intro);
        CommandRegestry.HELP.command.run(this.tmp_args);
    }
}
