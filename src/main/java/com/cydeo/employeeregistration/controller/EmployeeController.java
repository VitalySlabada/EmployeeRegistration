package com.cydeo.employeeregistration.controller;


import com.cydeo.employeeregistration.bootstrap.DataGenerator;
import com.cydeo.employeeregistration.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.cydeo.employeeregistration.bootstrap.DataGenerator.*;

@Controller
@RequestMapping ("/employee")
public class EmployeeController {


    @GetMapping("/register")
    public String createEmployee(Model model){

    model.addAttribute("employee", new Employee());
    model.addAttribute("states", getAllStates());


        return "/employee/employee-create";
    }

    @PostMapping ("/list")
    public String employeeList(@Valid @ModelAttribute ("employee") Employee employee,
                               BindingResult bindingResult,
                               Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("states", getAllStates());
            return "/employee/employee-create";
        }

        saveEmployee(employee);
        model.addAttribute("employees",DataGenerator.readAll());





        return "employee/employee-list";
    }
}
