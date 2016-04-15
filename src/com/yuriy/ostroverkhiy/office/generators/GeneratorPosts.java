package com.yuriy.ostroverkhiy.office.generators;

import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.posts.allPosts.*;
import com.yuriy.ostroverkhiy.office.random.TotalRandom;

import java.util.ArrayList;

public class GeneratorPosts {

    public PostController getNewPost(int count) {
        switch (count) {
            case 0:
                return new Director();
            case 1:
                return new Accountant();
            case 2:
                return new Manager();
            case 3:
                return new Cleaner();
            case 4:
                return new Designer();
            case 5:
                return new Programmer();
            case 6:
                return new Tester();
        }
        return null;
    }

    public ArrayList<PostController> getNecessaryPosts() {
        ArrayList<PostController> postControllers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            postControllers.add(getNewPost(i));
        }
        return postControllers;
    }

    private Class getCountOfPost(int count) {
        switch (count) {
            case 0:
                return Director.class;
            case 1:
                return Accountant.class;
            case 2:
                return Manager.class;
            case 3:
                return Cleaner.class;
            case 4:
                return Designer.class;
            case 5:
                return Programmer.class;
            case 6:
                return Tester.class;
        }
        return null;
    }


    public ArrayList<PostController> generatePosts() {
        Integer numberPosts = TotalRandom.rand(1, 1, 5).get(0);
        ArrayList<PostController> postsList = new ArrayList<>();
        for (int i = 0; i < numberPosts; i++) {
            Integer postCount = TotalRandom.rand(1, 0, 6).get(0);
            postsList = generatePostLogic(postsList, postCount);
        }
        return postsList;
    }

    private ArrayList<PostController> generatePostLogic(ArrayList<PostController> postsList, Integer postCount) {

        if (postsList.size() == 0) {
            postsList.add(getNewPost(postCount));  // first add
            return postsList;
        } else {
            int countAdd = 0;
            for (PostController post : postsList) {
                if (post.getClass().getName().equals(Cleaner.class.getName())) {
                    return postsList;
                }
                if (post.getClass().getName().equals(getCountOfPost(postCount).getName())) { // duplicate
                    return postsList;
                } else {
                    if (post.getClass().getName().equals(Director.class.getName()) || post.getClass().getName().equals(Accountant.class.getName())) {
                        if (!getCountOfPost(postCount).getName().equals(Manager.class.getName())) {
                            return postsList;
                        }
                    }
                    if (getCountOfPost(postCount).getName().equals(Cleaner.class.getName()) || getCountOfPost(postCount).getName().equals(Director.class.getName()) || getCountOfPost(postCount).getName().equals(Accountant.class.getName())) {
                        return postsList;
                    }
                    countAdd++;
                }
            }
            if (countAdd > 0) {
                postsList.add(getNewPost(postCount));
            }
        }
        return postsList;
    }
}
