package com.yuriy.ostroverkhiy.office.generators;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Freelancer;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.posts.allPosts.Cleaner;
import com.yuriy.ostroverkhiy.office.random.TotalRandom;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class GeneratorTasks {

    public Task getTask(PostController postController, LocalDateTime localDateTime, int taskCount) {
        Task task = new Task();
        task.setRunTime(TotalRandom.rand(1, 1, 2).get(0));
        task.setPriority(TotalRandom.rand(1, 1, 3).get(0));
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            task.setPriceInHour(postController.getHourlyRate() * 2);
        } else {
            task.setPriceInHour(postController.getHourlyRate());
        }
        task.setEndTimeOfTask(localDateTime.plusHours(task.getRunTime()));
        task.setPostController(postController);
        task.setAllPrice(task.getPriceInHour() * task.getRunTime());
        switch (taskCount) {
            case 1:
                task.setTaskDescription(postController.toDoFirstTask());
                break;
            case 2:
                task.setTaskDescription(postController.toDoSecondTask());
                break;
            case 3:
                task.setTaskDescription(postController.toDoThirdTask());
                break;
        }
        if (!postController.getClass().getName().equals(Cleaner.class.getName())) {
            task.setEmployeesController(Freelancer.class.getName());
        }
        return task;
    }
}
