package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Schema(description = "Código del salario")
    private int salaryId;


    @Schema(description = "Código del empleado asociado")
    private String codEmpleado;


    @Schema(description = "Coste por hora")
    private double costeHora;


    @Schema(description = "Nombre del empleado asociado")
    private String nombreEmpleado;


    @Schema(description = "Salario mensual")
    private double salary;

    @Schema(description = "Mes del salario")
    private int salaryMonth;

    @Schema(description = "Año del salario")
    private int salaryYear;
}
