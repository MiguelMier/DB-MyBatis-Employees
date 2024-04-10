package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.mappers.EmployeeMapper;
import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Double> getMonthlySalariesForEmployee(String employeeCode, int year) {
        return employeeMapper.getMonthlySalariesForEmployee(employeeCode,year);
    }

    @Override
    public List<Employee> searchEmployees(String name, String employeeCode, int pageSize, int offset) {
        return employeeMapper.searchEmployees(name, employeeCode, pageSize, offset);
    }

    @Override
    public List<Double> createSalaryList(String employeeCode, int year) {
        return employeeMapper.createSalaryList(employeeCode,year);
    }

    @Override
    public int updateSalaryFromEmployee(double salary, String employeeCode, int year, int month) {
         return employeeMapper.updateSalaryFromEmployee(salary,employeeCode,year,month);
    }
}
