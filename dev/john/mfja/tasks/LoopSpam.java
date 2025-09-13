package dev.john.mfja.tasks;

import dev.john.mfja.util.IConsole;
import dev.john.mfja.util.JMath;
import java.util.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TaskAnnotation {
    int exercise();
    String name();
}

abstract class YetAnotherTask {
    public IConsole out;

    public abstract void doSomething(int start);
}

@TaskAnnotation(exercise=1,name="Countdown")
class Countdown extends YetAnotherTask {
    @Override
    public void doSomething(int start) {
        while (start > 0) {
            this.out.print(String.valueOf(start));
            start --;
        }
    }
}

@TaskAnnotation(exercise=2,name="Sum of Integers (literally just factorial)")
class SumOfInts extends YetAnotherTask {
    private int thisFunctionHasAReturnOtherThanVoid(int start) {
        int total = 0;

        while (start > 0) { // we do this backwards because I just copy-pasted the above class and am too lazy to change this
            this.out.print("+ "+String.valueOf(start));
            total += start;
            start --;
        }

        this.out.print("= "+String.valueOf(total));
        return total;
    }
    
    @Override
    public void doSomething(int start) {
        this.thisFunctionHasAReturnOtherThanVoid(start);
    }
}

@TaskAnnotation(exercise=3,name="Sum of Even Numbers")
class SumOfEvens extends YetAnotherTask {
    private int thisFunctionAlsoHasAReturnOtherThanVoid(int start) {
        int total = 0;

        while (start > 0) { // we do this backwards because I just copy-pasted the above class and am too lazy to change this, including this comment.
            if (JMath.isEven(start)) {
                this.out.print("+ "+String.valueOf(start));
                total += start;
            }
            start --;
        }

        this.out.print("= "+String.valueOf(total));
        return total;
    }
    
    @Override
    public void doSomething(int start) {
        this.thisFunctionAlsoHasAReturnOtherThanVoid(start);
    }
}

@TaskAnnotation(exercise=4,name="Counting Multiples")
class CountingMultiples extends YetAnotherTask {
    private final String tangent = "a number that is not more than but instead equal to a number that is equal to or less than "; // why not have some fun

    private int anotherNonVoidFunction(int start, int k) {
        int count = 0;
        if (k > start) {
            this.out.print("the number "+String.valueOf(k)+" violates the above logical statement");
            return 0;
        }
        while (start > 0) {
            if (JMath.isMultipleOf(start, k)) {
                this.out.print(String.valueOf(start)+" is a multiple of "+String.valueOf(k));
                count ++;
            }
            start --;
        }
        return count;
    }

    @Override
    public void doSomething(int start) {
        final int quality_control = JMath.demandIntByForce(this.tangent+String.valueOf(start), this.out);
        this.out.print("the total number of multiples less than "+String.valueOf(start)+" of "+this.tangent+String.valueOf(start)+", in this case "+String.valueOf(quality_control)+", is "+String.valueOf(
            this.anotherNonVoidFunction(start, quality_control)
        ));
    }
}

@TaskAnnotation(exercise=5,name="Count Digits")
class IntLength extends YetAnotherTask {
    @Override
    public void doSomething(int start) {
        this.out.print("the number "+String.valueOf(start)+" is "+String.valueOf(JMath.lengthOfInt(start))+" chars long");
    }
}

@TaskAnnotation(exercise=6,name="Count Odd Digits")
class OddLength extends YetAnotherTask {
    private int wayMoreCompilcatedThanItShouldBe(int start) {
        final String string = String.valueOf(start);
        int index = 0; // please just let me use a for loop
        int count = 0;
        while (index < JMath.lengthOfInt(start)) { // Abstraction comes in handy
            if (!JMath.isEven(Integer.parseInt(String.valueOf(string.charAt(index))))) { // Don't you love decorator patterns?
                count ++;
            }
            index ++;
        }
        return count;
    }

    @Override
    public void doSomething(int start) { //I present a hacky solution that somehow works
        this.out.print(String.valueOf(this.wayMoreCompilcatedThanItShouldBe(start)));
    }
}

public class LoopSpam extends Task {

        public LoopSpam(IConsole out) {
            super(out);
    }

    private enum EvenMoreTasks {
        COUNTDOWN(new Countdown()),
        SUMOFINTS(new SumOfInts()),
        SUMOFEVENS(new SumOfEvens()),
        COUNTINGMULTIPLES(new CountingMultiples()),
        INTLENGTH(new IntLength()),
        ODDLENGTH(new OddLength());

        private YetAnotherTask task;

        private EvenMoreTasks(YetAnotherTask thistask) {
            this.task = thistask;
        }
    }

    private void describeAnnotation(TaskAnnotation annotation) {
        this.out.print("- Exercise "+String.valueOf(annotation.exercise())+": "+annotation.name());
        this.out.sleep(1);
    }

    @Override
    public void run() {
        int count = JMath.demandIntByForce("# of iterations", this.out);
        
        for (EvenMoreTasks task : EvenMoreTasks.values()) {
            final TaskAnnotation annotation = task.task.getClass().getAnnotation(TaskAnnotation.class);
            this.describeAnnotation(annotation);

            task.task.out = this.out;
            task.task.doSomething(count);
        }
    }
}
