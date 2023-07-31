package com.example.testspring.controller;

import com.example.testspring.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
@RequestMapping("/employee")
public class EmployeeController {
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){
        Employee emp1 = new Employee(1,"Dang","Huy","nguyenhuy18796@gmail.com");
        Employee emp2 = new Employee(2,"Nguyen","Nam","phuongnam@gmail.com");
        Employee emp3 = new Employee(3,"Trinh","Hiep","trinhhiep@gmail.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }
    @GetMapping("/list")
    public String listEmployee(Model theModel) {
        theModel.addAttribute("employees",theEmployees);
        return "list_employees";
    }

}
