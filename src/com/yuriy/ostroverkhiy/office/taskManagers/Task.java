package com.yuriy.ostroverkhiy.office.taskManagers;

import com.yuriy.ostroverkhiy.office.posts.PostController;

import java.time.LocalDateTime;

public class Task {
    private Integer priority;
    private Integer priceInHour;
    private Integer runTime;
    private int allPrice;
    private LocalDateTime endTimeOfTask;
    private String taskDescription;
    private PostController postController;
    private boolean paid = false;
    private String employeesController;


    public Integer getPriority() {
        return priority;
    }

    public int getPriceInHour() {
        return priceInHour;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setPriceInHour(int priceInHour) {
        this.priceInHour = priceInHour;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public LocalDateTime getEndTimeOfTask() {
        return endTimeOfTask;
    }

    public void setEndTimeOfTask(LocalDateTime endTimeOfTask) {
        this.endTimeOfTask = endTimeOfTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public PostController getPostController() {
        return postController;
    }

    public void setPostController(PostController postController) {
        this.postController = postController;
    }

    public Integer getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Integer allPrice) {
        this.allPrice = allPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getEmployeesController() {
        return employeesController;
    }

    public void setEmployeesController(String employeesController) {
        this.employeesController = employeesController;
    }

}
