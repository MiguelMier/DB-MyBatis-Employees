package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT salary FROM salary WHERE codempleado = #{employeeCode} AND salaryyear = #{year}")
    List<Double> getMonthlySalariesForEmployee(@Param("employeeCode") String employeeCode, @Param("year") int year);

    @Select("SELECT * FROM employee WHERE nombreempleado LIKE CONCAT('%', #{name}, '%') AND codempleado = #{employeeCode} LIMIT #{pageSize} OFFSET #{offset}")
    List<Employee> searchEmployees(@Param("name") String name, @Param("employeeCode") String employeeCode, @Param("pageSize") int pageSize, @Param("offset") int offset);

    @Insert("Insert ")
    List<Double> createSalaryList(String employeeCode, int year);

    @Update("UPDATE salary SET SALARY  = #{salary} WHERE CODEMPLEADO  = #{codempleado} AND SALARYYEAR  = #{year} AND SALARYMONTH  = #{month};")
    int updateSalaryFromEmployee(@Param("salary")double salary, @Param("codempleado")String codempleado, @Param("year")int year, @Param("month")int month);
}
