package dev.john.mfja.tasks.advent.commands;

import dev.john.mfja.tasks.advent.Command;
import dev.john.mfja.tasks.advent.AdventConsole;

public class HelpCommand extends Command {

    public HelpCommand(AdventConsole console) {
        super(console);
    }

    @Override
    public void run(String[] args) {
        for (String arg : args) {
            this.console.system(arg);
        }
    }
}
