package com.helloworld.salaries.mybatis;

import com.helloworld.salaries.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELET * FROM EMPLOYEE")
    List<Employee> findAllEmployees();
}
