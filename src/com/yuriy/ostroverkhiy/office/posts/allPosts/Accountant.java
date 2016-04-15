package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Employee;
import com.yuriy.ostroverkhiy.office.employees.allEmpl.Freelancer;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.util.ArrayList;

public class Accountant extends PostController {
    public Accountant() {
        monthlyRate = 3000;
    }

    public Employee salaryForEmployee(Employee employee) {
        ArrayList<Task> newFinishedTasks = new ArrayList<>();
        ArrayList<Task> finishedTaskList = employee.getFinishedTaskList();
        for (PostController post : employee.getPosts()) {
            if (post.getClass().getName().equals(Director.class.getName()) || post.getClass().getName().equals(Accountant.class.getName()) || post.getClass().getName().equals(Manager.class.getName())) {
                if (post.getMonthlyRate() > employee.getSalary()) {
                    int monthlyRate = post.getMonthlyRate();
                    employee.setSalary(monthlyRate / 4);
                }
            }
        }
        for (Task task : finishedTaskList) {
            if (!task.isPaid()) {
                Integer allPrice = task.getAllPrice();
                employee.setSalary(allPrice);
                task.setPaid(true);
            }
            newFinishedTasks.add(task);
        }
        employee.setFinishedTaskList(newFinishedTasks);

        return employee;
    }

    public Freelancer salaryForFreelancer(Freelancer freelancer) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (PostController post : freelancer.getPosts()) {
            if (post.getClass().getName().equals(Director.class.getName()) || post.getClass().getName().equals(Accountant.class.getName()) || post.getClass().getName().equals(Manager.class.getName())) {
                int monthlyRate = post.getMonthlyRate();
                for (Task task : freelancer.getFinishedTaskList()) {
                    if (!task.isPaid()) {
                        freelancer.setSalary(task.getRunTime() * (monthlyRate / 168));
                        task.setPaid(true);
                    }
                    tasks.add(task);
                }
                freelancer.setFinishedTaskList(tasks);
                return freelancer;
            }
        }
        for (Task task : freelancer.getFinishedTaskList()) {
            if (!task.isPaid()) {
                freelancer.setSalary(task.getAllPrice());
                task.setPaid(true);
            }
            tasks.add(task);
        }
        freelancer.setFinishedTaskList(tasks);
        return freelancer;
    }

    @Override
    public String toDoFirstTask() {
        return toPrepareStatements();
    }

    @Override
    public String toDoSecondTask() {
        return toMakeOutputLabel();
    }

    @Override
    public String toDoThirdTask() {
        return toMakeInputLabel();
    }

    private String toPrepareStatements() {
        return "toPrepareStatements";
    }

    private String toMakeOutputLabel() {
        return "toMakeOutputLabel";
    }

    private String toMakeInputLabel() {
        return "toMakeInputLabel";
    }
}
