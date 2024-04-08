package com.helloworld.salaries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String codEmpleado;
    private String nombreEmpleado;
    private Date fechaInicio;
    private Date fechaBaja;
    private int office;
}
