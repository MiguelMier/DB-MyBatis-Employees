package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT salary FROM salary WHERE codempleado = #{employeeCode} AND salaryyear = #{year}")
    List<Double> getMonthlySalariesForEmployee(@Param("employeeCode") String employeeCode, @Param("year") int year);
}
