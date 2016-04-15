package com.yuriy.ostroverkhiy.office.generators;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Freelancer;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.util.ArrayList;

public class GeneratorFreelancer {

    public ArrayList<Freelancer> generateNewFreelancer(Task task, ArrayList<Freelancer> freelancersList, ArrayList<PostController> posts) {
        Freelancer freelancer = new Freelancer();
        freelancer.setPosts(posts);
        freelancer.setHoursDay(8);
        freelancer.setHoursWeek(40);
        freelancer.setSequenceNumberOfWorker(freelancersList.size() + 1);
        freelancer.setTask(task);
        freelancersList.add(freelancer);
        return freelancersList;
    }

}
