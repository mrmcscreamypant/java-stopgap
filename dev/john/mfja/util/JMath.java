package dev.john.mfja.util;

import java.lang.Math;

public class JMath {

    public static boolean isEven(int number) {
        return JMath.isMultipleOf(number, 2);
    }

    public static boolean isMultipleOf(int canadate, int number) {
        return (canadate % number == 0);
    }

    public static int demandIntByForce(String prompt, IConsole out) {
        while (true) {
            final String probably_not_an_int = out.prompt(prompt);
            int should_be_an_int;
            try {
                should_be_an_int = Integer.parseInt(probably_not_an_int);
                return should_be_an_int;
            } catch (NumberFormatException e) {
                out.print("'" + probably_not_an_int + "' is not an int (or is way too big)");
            }
        }
    }

    public static double demandDoubleByForce(String prompt, IConsole out) {
        while (true) {
            final String probably_not_a_double = out.prompt(prompt);
            double should_be_a_double;
            try {
                should_be_a_double = Double.valueOf(probably_not_a_double);
                return should_be_a_double;
            } catch (NumberFormatException e) {
                out.print("'" + probably_not_a_double + "' is not a double (or is way too big)");
            }
        }
    }

    public static int lengthOfInt(int number) {
        return (int) Math.log10(number) + 1;
    }
}
