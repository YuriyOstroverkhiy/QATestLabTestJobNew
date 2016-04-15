package com.yuriy.ostroverkhiy.office.posts;

public abstract class PostController implements PostsProvider {
    protected int hourlyRate;
    protected int monthlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getMonthlyRate() {
        return monthlyRate;
    }

}
