package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;

public class LoopSpam extends Task {

    public LoopSpam(IConsole out) {
        super(out);
    }

    private void doSpam(int count) {
        for (int i = 0; i < count; i++) {
            this.out.print(String.valueOf(i));
        }
    }

    @Override
    public void run() {
        final String bad_input = this.out.prompt("# of iterations");
        int how_much_pain_will_I_be_in;
        try {
            how_much_pain_will_I_be_in = Integer.parseInt(bad_input);
        } catch (NumberFormatException e) {
            this.out.print("'"+bad_input+"' is not a number (or is way too big)");
            return;
        }
        this.doSpam(how_much_pain_will_I_be_in);
    }
}
