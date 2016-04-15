package com.yuriy.ostroverkhiy.office;

import com.yuriy.ostroverkhiy.office.employees.allEmpl.Employee;
import com.yuriy.ostroverkhiy.office.employees.allEmpl.Freelancer;
import com.yuriy.ostroverkhiy.office.generators.GeneratorEmployee;
import com.yuriy.ostroverkhiy.office.generators.GeneratorFreelancer;
import com.yuriy.ostroverkhiy.office.posts.PostController;
import com.yuriy.ostroverkhiy.office.posts.allPosts.Accountant;
import com.yuriy.ostroverkhiy.office.posts.allPosts.Director;
import com.yuriy.ostroverkhiy.office.summary.Summary;
import com.yuriy.ostroverkhiy.office.taskManagers.Task;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class OfficeStart {

    ArrayList<Freelancer> freelancerArrayList = new ArrayList<>();

    public void startAll() {
        GeneratorEmployee generatorEmployee = new GeneratorEmployee();
        Director director = new Director();
        Accountant accountant = new Accountant();

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        localDateTime = localDateTime.minusHours(localDateTime.getHour());
        localDateTime = localDateTime.minusMinutes(localDateTime.getMinute());
        ArrayList<Employee> employeeList = generatorEmployee.generateEmployeesList();
        LocalDateTime startData = localDateTime;
        LocalDateTime endDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());

        while (!endDateTime.equals(localDateTime)) {
            if (localDateTime.getHour() >= 8 && localDateTime.getHour() <= 17) {
                employeeList = newTasks(employeeList, director, localDateTime, accountant);
            }
            if (startData.plusDays(1).equals(localDateTime)) {
                startData = localDateTime;
                ArrayList<Freelancer> freelancers = new ArrayList<>();
                for (Freelancer freelancer : this.getFreelancerArrayList()) {
                    freelancers.add((accountant.salaryForFreelancer(freelancer)));
                }
                this.setFreelancerArrayList(freelancers);
            }
            localDateTime = localDateTime.plusHours(1);
        }

        ArrayList<Freelancer> freelancers = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        for (Freelancer freelancer : getFreelancerArrayList()) {
            freelancers.add((accountant.salaryForFreelancer(freelancer)));
        }
        for (Employee employee : employeeList) {
            employee = accountant.salaryForEmployee(employee);
            employees.add(employee);
        }
        employeeList = employees;
        setFreelancerArrayList(freelancers);
        Summary summary = new Summary();
        summary.getSummary(employeeList, getFreelancerArrayList());
    }

    private ArrayList<Employee> newTasks(ArrayList<Employee> employeeList, Director director, LocalDateTime localDateTime, Accountant accountant) {
        ArrayList<Employee> employees = new ArrayList<>();
        GeneratorFreelancer generatorFreelancer = new GeneratorFreelancer();
        for (Employee employee : employeeList) {
            employee = setNewDayOrWeek(employee, localDateTime, accountant);
            employees.add(employee);
        }
        employeeList = director.giveTaskToAllEmployees(employees, localDateTime);

        for (Task task : director.getMainListTasks()) {
            if (task.getEmployeesController() != null) {
                if (task.getEmployeesController().equals(Freelancer.class.getName())) {
                    ArrayList<PostController> postControllers = new ArrayList<>();
                    postControllers.add(task.getPostController());
                    this.freelancerArrayList = generatorFreelancer.generateNewFreelancer(task, this.getFreelancerArrayList(), postControllers);
                }
            }

        }
        return employeeList;
    }

    private Employee setNewDayOrWeek(Employee employee, LocalDateTime localDateTime, Accountant accountant) {
        if (employee.getLocalDateTime() == null) {
            employee.setLocalDateTime(localDateTime);
            employee.setStartLocalDateTime(localDateTime);
        } else {
            if (!employee.getLocalDateTime().getDayOfWeek().equals(localDateTime.getDayOfWeek())) {
                employee.setLocalDateTime(localDateTime);
                employee.setHoursDay(8);
            }
            if (employee.getStartLocalDateTime().plusDays(7).equals(localDateTime)) {
                employee.setStartLocalDateTime(localDateTime);
                employee.setHoursWeek(40);
                employee = accountant.salaryForEmployee(employee);
            }
        }
        return employee;
    }

    public ArrayList<Freelancer> getFreelancerArrayList() {
        return freelancerArrayList;
    }

    public void setFreelancerArrayList(ArrayList<Freelancer> freelancerArrayList) {
        this.freelancerArrayList = freelancerArrayList;
    }
}
