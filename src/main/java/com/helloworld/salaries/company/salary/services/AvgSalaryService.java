package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;

import java.util.List;

public interface AvgSalaryService {

    double getAvgSalary(int year) throws WrongParamsException;

    //List<Employee> getAllEmployees();
}
