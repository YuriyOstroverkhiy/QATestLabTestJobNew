package com.yuriy.ostroverkhiy.office.summary;

import com.yuriy.ostroverkhiy.office.Main;
import com.yuriy.ostroverkhiy.office.employees.WorkersController;
import com.yuriy.ostroverkhiy.office.employees.allEmpl.Employee;
import com.yuriy.ostroverkhiy.office.employees.allEmpl.Freelancer;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Summary {
    public void getSummary(ArrayList<Employee> employeeList, ArrayList<Freelancer> freelancerList) {

        ArrayList<String> str = new ArrayList<>();
        int salaryEm = 0;
        int salaryFr = 0;
        int tasksSize = 0;
        for (Employee employee : employeeList) {
            salaryEm += employee.getSalary();
            tasksSize += employee.getFinishedTaskList().size();
        }
        for (Freelancer freelancer : freelancerList) {
            salaryFr += freelancer.getSalary();
        }
        str.add("Employees: " + employeeList.size());
        str.add("Employees tasks:" + tasksSize);
        str.add("Salary employees: " + salaryEm + "$");
        str.add("Tasks to Freelancers: " + freelancerList.size());
        str.add("Salary freelancers: " + salaryFr + "$");
        int allTasks = freelancerList.size() + tasksSize;
        str.add("All tasks: " + allTasks);
        int salaryAll = salaryEm + salaryFr;
        str.add("Salary of All workers: " + salaryAll + "$");
        str.add("----------------------------------------Employees:-----------------------------------------");
        str = getListStringToPrint(employeeList, str, false);
        str.add("----------------------------------------Freelancers:-----------------------------------------");
        str = getListStringToPrint(freelancerList, str, false);
        str.add("----------------------------------------Detailed:--------------------------------------------");
        str.add("----------------------------------------Employees detailed:-----------------------------------------");
        str = getListStringToPrint(employeeList, str, true);
        str.add("----------------------------------------Freelancers detailed:-----------------------------------------");
        str = getListStringToPrint(freelancerList, str, true);


        Writer writer = null;
        try {
            writer = new FileWriter("D:\\file.txt");
            for (String line : str) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }

    }

    private ArrayList<String> getListStringToPrint(ArrayList<? extends WorkersController> employeeList, ArrayList<String> str, boolean isDetailed) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, EEEE, yyyy - HH:mm");
        for (WorkersController workersController : employeeList) {
            str.add("------------------- " + workersController.getSequenceNumberOfWorker() + " -------------------");
            for (PostController post : workersController.getPosts()) {
                str.add(post.getClass().getSimpleName());
            }
            ArrayList<Task> finishedTaskList = workersController.getFinishedTaskList();
            str.add("Tasks: " + finishedTaskList.size());
            str.add("* * * * *");
            int globalTasksTime = 0;
            for (Task task : finishedTaskList) {
                globalTasksTime += task.getRunTime();
                if (isDetailed) {
                    str.add(task.getPostController().getClass().getSimpleName() + ": " + task.getTaskDescription());
                    str.add("Tasks priority: " + task.getPriority());
                    str.add("Run time: " + task.getRunTime() + "h");
                    str.add("EndTime: " + formatter.format(task.getEndTimeOfTask()));
                    str.add("Tasks price: " + task.getAllPrice() + "$");
                    str.add("* * * * *");
                }
            }
            str.add("Global Time: " + globalTasksTime + "h");
            str.add("Salary: " + workersController.getSalary() + "$");
            str.add("------------------------------------------------------------------");
        }
        str.add("----------------------------------------------------------------------------------------------------------------------------");
        return str;
    }
}
