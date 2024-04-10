package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;

import java.util.List;

public interface EmployeeService {
    List<Double> getMonthlySalariesForEmployee(String employeeCode, int year);

    List<Employee> searchEmployees(String name, String employeeCode, int pageSize, int offset);

    //int updateMonthlySalary(String employeeCode, int year, int month, double salary);

    List<Double> createSalaryList(String employeeCode, int year);

    int updateSalaryFromEmployee(double salary, String employeeCode, int year, int month);
}
