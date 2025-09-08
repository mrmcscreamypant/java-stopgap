package dev.john.mfja.tasks;

import dev.john.mfja.util.IRegestry;
import java.util.HashMap;

public class TaskRegestry implements IRegestry<TaskRegestryObject> {

    @Override
    public HashMap<String, TaskRegestryObject> items(Object args[]) {
        HashMap<String, TaskRegestryObject> map = new HashMap<>();

        map.put("int-size", new TaskRegestryObject());

        return map;
    }

}
