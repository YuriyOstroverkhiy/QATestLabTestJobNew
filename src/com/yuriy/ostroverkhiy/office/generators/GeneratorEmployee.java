package com.yuriy.ostroverkhiy.office.generators;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Employee;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.random.TotalRandom;

import java.util.ArrayList;

public class GeneratorEmployee {

    private ArrayList<Employee> generateNecessaryEmployees(GeneratorPosts generatorPosts, ArrayList<Employee> employeeList) {
        ArrayList<PostController> necessaryPosts = generatorPosts.getNecessaryPosts();
        for (int i = 0; i < necessaryPosts.size(); i++) {
            Employee employee = new Employee();
            ArrayList<PostController> post = new ArrayList<>();
            post.add(necessaryPosts.get(i));
            employee.setPosts(post);
            employee.setSequenceNumberOfWorker(i + 1);
            employee.setHoursDay(8);
            employee.setHoursWeek(40);
            employeeList.add(employee);
        }
        return employeeList;

    }

    private Employee generateOneEmployee(GeneratorPosts generatorPosts, int count) {
        Employee employee = new Employee();
        employee.setPosts(generatorPosts.generatePosts());
        employee.setSequenceNumberOfWorker(count + 1);
        employee.setHoursDay(8);
        employee.setHoursWeek(40);
        return employee;
    }

    public ArrayList<Employee> generateEmployeesList() {
        Integer employeesNumber = TotalRandom.rand(1, 10, 100).get(0); // количество сотрудников
        GeneratorPosts generatorPosts = new GeneratorPosts();
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList = generateNecessaryEmployees(generatorPosts, employeeList);
        for (int i = employeeList.size(); i < employeesNumber; i++) {
            employeeList.add(generateOneEmployee(generatorPosts, i));
        }
        return employeeList;
    }
}
