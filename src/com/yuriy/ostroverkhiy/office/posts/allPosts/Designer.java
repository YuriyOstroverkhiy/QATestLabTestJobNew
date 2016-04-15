package com.yuriy.ostroverkhiy.office.posts.allPosts;

import com.yuriy.ostroverkhiy.office.posts.PostController;

public class Designer extends PostController {

    public Designer() {
        hourlyRate = 60;
    }

    @Override
    public String toDoFirstTask() {
        return toDrawLayout();
    }

    @Override
    public String toDoSecondTask() {
        return toMakeChanges();
    }

    @Override
    public String toDoThirdTask() {
        return toVerifyLayout();
    }


    private String toDrawLayout() {
        return "toDrawLayout";
    }

    private String toMakeChanges() {
        return "toMakeChanges";
    }

    private String toVerifyLayout() {
        return "toVerifyLayout";
    }


}
