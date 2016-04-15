package com.yuriy.ostroverkhiy.office.employees;

import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class WorkersController {

    protected int sequenceNumberOfWorker;
    protected ArrayList<PostController> posts;
    protected Task task;
    protected int hoursDay;
    protected int hoursWeek;
    protected LocalDateTime localDateTime;
    protected ArrayList<Task> finishedTaskList = new ArrayList<>();
    protected int salary = 0;
    protected LocalDateTime startLocalDateTime;

    public ArrayList<PostController> getPosts() {
        return this.posts;
    }

    public void setPosts(ArrayList<PostController> posts) {
        this.posts = posts;
    }

    public int getHoursDay() {
        return this.hoursDay;
    }

    public void setHoursDay(int hoursDay) {
        this.hoursDay = hoursDay;
    }

    public int getHoursWeek() {
        return this.hoursWeek;
    }

    public void setHoursWeek(int hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        if (hoursDay >= task.getRunTime() && hoursWeek >= task.getRunTime()) {
            this.setHoursDay(hoursDay - task.getRunTime());
            this.setHoursWeek(hoursWeek - task.getRunTime());
            this.task = task;
            this.finishedTaskList.add(this.task);
        }
    }

    public ArrayList<Task> getFinishedTaskList() {
        return this.finishedTaskList;
    }

    public void setFinishedTaskList(ArrayList<Task> finishedTaskList) {
        this.finishedTaskList = finishedTaskList;
    }

    public int getSequenceNumberOfWorker() {
        return this.sequenceNumberOfWorker;
    }

    public void setSequenceNumberOfWorker(int sequenceNumberOfWorker) {
        this.sequenceNumberOfWorker = sequenceNumberOfWorker;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = this.salary + salary;
    }

    public LocalDateTime getStartLocalDateTime() {
        return startLocalDateTime;
    }

    public void setStartLocalDateTime(LocalDateTime startLocalDateTime) {
        this.startLocalDateTime = startLocalDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;

    }
}
