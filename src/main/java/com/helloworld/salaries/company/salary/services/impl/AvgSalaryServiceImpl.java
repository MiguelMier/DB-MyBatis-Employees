package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.mybatis.AvgSalaryMapper;
import com.helloworld.salaries.mybatis.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AvgSalaryServiceImpl implements AvgSalaryService {

    private final int minimalYear = 2000;
    //private final EmployeeMapper employeeMapper;
    private final AvgSalaryMapper avgSalaryMapper;

    public AvgSalaryServiceImpl(AvgSalaryMapper avgSalaryMapper) {
        this.avgSalaryMapper = avgSalaryMapper;
    }


    @Override
    public double getAvgSalary(int year) throws WrongParamsException {
        validateYear(year);
        return avgSalaryMapper.getAvgSalary(year);
    }


    private void validateYear(int year) throws WrongParamsException {
            if (year < this.minimalYear || year > LocalDate.now().getYear()) {
                throw new WrongParamsException("year");
            }
        }


}
