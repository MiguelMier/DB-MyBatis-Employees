package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Schema(description = "Código del empleado")
    private String codEmpleado;

    @Schema(description = "Nombre del empleado")
    private String nombreEmpleado;

    @Schema(description = "Fecha de inicio de trabajo")
    private Date fechaInicio;

    @Schema(description = "Fecha de baja de trabajo")
    private Date fechaBaja;

    @Schema(description = "Código de la oficina asociada")
    private int office;
}
