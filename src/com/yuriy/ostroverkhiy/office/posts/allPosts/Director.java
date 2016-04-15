package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Employee;
import com.yuriy.ostroverkhiy.office.generators.GeneratorPosts;
import com.yuriy.ostroverkhiy.office.generators.GeneratorTasks;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.random.TotalRandom;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Director extends PostController {
    public Director() {
        monthlyRate = 15000;
    }

    private ArrayList<Task> mainListTasks;

    @Override
    public int getMonthlyRate() {
        return this.monthlyRate;
    }

    private boolean isTaskBest(Task task, Task newTask) {
        if (task.getPriority() > newTask.getPriority())
            return true;
        if (task.getPriority().equals(newTask.getPriority()) && task.getPriceInHour() < newTask.getPriceInHour())
            return true;
        return false;
    }

    private ArrayList<Task> getNewListTasks(int employeesNumber, LocalDateTime localDateTime) {
        GeneratorTasks generatorTasks = new GeneratorTasks();
        ArrayList<Task> taskArrayList = new ArrayList<>();
        GeneratorPosts generatorPosts = new GeneratorPosts();
        Integer tasksNumber = TotalRandom.rand(1, 1, employeesNumber).get(0);
        for (Integer i = 0; i < tasksNumber; i++) {
            Integer postCount = TotalRandom.rand(1, 1, 6).get(0);
            PostController post = generatorPosts.getNewPost(postCount);
            if (!post.getClass().getName().equals(Director.class.getName())) {
                Integer taskCount = TotalRandom.rand(1, 1, 3).get(0);
                Task newTask = generatorTasks.getTask(post, localDateTime, taskCount);
                taskArrayList.add(newTask);
            }
        }
        return taskArrayList;
    }

    public ArrayList<Employee> giveTaskToAllEmployees(ArrayList<Employee> employeeArrayList, LocalDateTime localDateTime) {
        mainListTasks = getNewListTasks(employeeArrayList.size(), localDateTime);
        ArrayList<Employee> newEmployeeArrayList = new ArrayList<>();
        for (Employee employee : employeeArrayList) {
            if (employee.getTask() != null) {
                if (employee.getTask().getEndTimeOfTask().isBefore(localDateTime.plusSeconds(1))) {
                    Task task = getSortedTask(mainListTasks, employee);
                    if (task != null) {
                        employee.setTask(task);
                    }
                }
            } else {
                Task task = getSortedTask(mainListTasks, employee);
                if (task != null) {
                    employee.setTask(task);
                }
            }
            newEmployeeArrayList.add(employee);
        }
        return newEmployeeArrayList;
    }

    private Task getSortedTask(ArrayList<Task> taskArrayList, Employee employee) {
        Task newTask = null;
        for (PostController postController : employee.getPosts()) {
            for (Task task : taskArrayList) {
                if (postController.getClass().getName().equals(task.getPostController().getClass().getName())) {
                    if (newTask == null) {
                        newTask = task;
                    }
                    if (isTaskBest(task, newTask)) {
                        newTask = task;
                    }
                }
            }
        }
        if (newTask != null) {
            if (employee.getHoursDay() >= newTask.getRunTime() && employee.getHoursWeek() >= newTask.getRunTime()) {
                ArrayList<Task> tasks = new ArrayList<>();
                for (Task task : taskArrayList) {
                    if (task == newTask) {
                        task.setEmployeesController(Employee.class.getName());
                    } else {
                        tasks.add(task);
                    }
                }
                this.setMainListTasks(tasks);
            }
        }
        return newTask;
    }

    @Override
    public String toDoFirstTask() {
        return "";
    }

    @Override
    public String toDoSecondTask() {
        return "";
    }

    @Override
    public String toDoThirdTask() {
        return "";
    }


    public ArrayList<Task> getMainListTasks() {
        return mainListTasks;
    }

    public void setMainListTasks(ArrayList<Task> mainListTasks) {
        this.mainListTasks = mainListTasks;
    }
}
