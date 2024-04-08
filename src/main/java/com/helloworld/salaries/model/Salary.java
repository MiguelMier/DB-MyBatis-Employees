package com.helloworld.salaries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    private int salaryId;
    private String codEmpleado;
    private double costeHora;
    private String nombreEmpleado;
    private double salary;
    private int salaryMonth;
    private int salaryYear;
}
