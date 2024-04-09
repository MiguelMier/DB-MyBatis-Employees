package com.helloworld.salaries.company.salary.services;

import java.util.List;

public interface EmployeeService {
    List<Double> getMonthlySalariesForEmployee(String employeeCode, int year);
}
