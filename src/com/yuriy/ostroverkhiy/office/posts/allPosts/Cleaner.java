package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.posts.PostController;

public class Cleaner extends PostController {

    public Cleaner() {
        hourlyRate = 10;
    }

    @Override
    public String toDoFirstTask() {
        return performCleaningInOffice();
    }

    @Override
    public String toDoSecondTask() {
        return performCleaningOnStreet();
    }

    @Override
    public String toDoThirdTask() {
        return performCleaningWithoutHands();
    }


    private String performCleaningInOffice() {
        return "performCleaningInOffice";
    }

    private String performCleaningOnStreet() {
        return "performCleaningOnStreet";
    }

    private String performCleaningWithoutHands() {
        return "performCleaningWithoutHands";
    }
}
