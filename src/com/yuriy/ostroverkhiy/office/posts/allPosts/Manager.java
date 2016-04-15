package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.posts.PostController;

public class Manager extends PostController {
    public Manager() {
        monthlyRate = 10000;
    }

    @Override
    public int getMonthlyRate() {
        return this.monthlyRate;
    }

    @Override
    public String toDoFirstTask() {
        return toSellServices();
    }

    @Override
    public String toDoSecondTask() {
        return answerCalls();
    }

    @Override
    public String toDoThirdTask() {
        return toInventNewProducts();
    }


    private String toSellServices() {
        return "toSellServices";
    }

    private String answerCalls() {
        return "answerCalls";
    }

    private String toInventNewProducts() {
        return "toInventNewProducts";
    }
}
