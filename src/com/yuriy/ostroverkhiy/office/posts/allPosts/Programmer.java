package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.posts.PostController;

public class Programmer extends PostController {

    public Programmer() {
        hourlyRate = 40;
    }

    @Override
    public String toDoFirstTask() {
        return toWriteCode();
    }

    @Override
    public String toDoSecondTask() {
        return toStudyTechnicalTask();
    }

    @Override
    public String toDoThirdTask() {
        return toGiveAdvise();
    }


    private String toWriteCode() {
        return "toWriteCode";
    }

    private String toStudyTechnicalTask() {
        return "toStudyTechnicalTask";
    }

    private String toGiveAdvise() {
        return "toGiveAdvise";
    }
}
