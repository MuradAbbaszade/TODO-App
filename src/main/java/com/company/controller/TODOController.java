package com.company.controller;

import com.company.bean.Task;
import com.company.util.TaskUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TODOController {

    private TaskUtil taskUtil = new TaskUtil();

    @GetMapping
    public ModelAndView showTodoPage() {
        ModelAndView mv = new ModelAndView("todo");
        mv.addObject("tasks", taskUtil.getTasks());
        return mv;
    }

    @PostMapping
    public ModelAndView showTodoPage(@RequestParam(value = "task", required = false) String taskDesc,
            @RequestParam(value = "button", required = false) String button,
            @RequestParam(value = "taskId", required = false) String taskId,
            HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("todo");
        System.out.println(button + taskId);
        if (button.equals("delete")) {
            Task task = taskUtil.getById(Integer.valueOf(taskId));
            taskUtil.getTasks().remove(task);
            response.sendRedirect("/TODO-App/");
            return mv;
        }
        if (button.equals("finished")) {
            Task task = taskUtil.getById(Integer.valueOf(taskId));
            task.setStatus("Finished");
            response.sendRedirect("/TODO-App/");
            return mv;
        }
        Task task = new Task(taskDesc, "In Progress");
        taskUtil.getTasks().add(task);
        task.setId(task.hashCode());
        response.sendRedirect("/TODO-App/");
        return mv;
    }
}
