package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.posts.PostController;

public class Tester extends PostController {


    public Tester() {
        hourlyRate = 30;
    }

    @Override
    public String toDoFirstTask() {
        return toTestProgram();
    }

    @Override
    public String toDoSecondTask() {
        return toGiveAdvise();
    }

    @Override
    public String toDoThirdTask() {
        return toTestWebSite();
    }


    private String toTestProgram() {
        return "toTestProgram";
    }

    private String toGiveAdvise() {
        return "toGiveAdvise";
    }

    private String toTestWebSite() {
        return "toTestWebSite";
    }
}
