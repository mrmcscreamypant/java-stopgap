package dev.john.mfja.tasks;

import dev.john.mfja.util.RegestryObject;

public class TaskRegestryObject extends RegestryObject<ITask> {

    public Object new_instance() {
        try {
            return this.child;
        } catch (Exception e) {
            System.out.println("Whoops, ");
            e.printStackTrace(System.out);
            System.exit(1);
            return new Object();
        }
    }
}
