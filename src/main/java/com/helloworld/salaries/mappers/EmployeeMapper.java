package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT salary FROM salary WHERE codempleado = #{employeeCode} AND salaryyear = #{year}")
    List<Double> getMonthlySalariesForEmployee(@Param("employeeCode") String employeeCode, @Param("year") int year);

    @Select("SELECT * FROM employee WHERE nombreempleado LIKE CONCAT('%', #{name}, '%') AND codempleado = #{employeeCode} LIMIT #{pageSize} OFFSET #{offset}")
    List<Employee> searchEmployees(@Param("name") String name, @Param("employeeCode") String employeeCode, @Param("pageSize") int pageSize, @Param("offset") int offset);

    @Insert("Insert ")
    List<Double> createSalaryList(String employeeCode, int year);
}
