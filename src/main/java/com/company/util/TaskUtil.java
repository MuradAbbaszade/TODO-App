package com.company.util;

import com.company.bean.Task;
import com.company.controller.TODOController;
import java.util.ArrayList;
import java.util.List;

public class TaskUtil {

    private List<Task> tasks = new ArrayList<Task>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getById(int id) {
        
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
