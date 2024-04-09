package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Schema(description = "Código del empleado")
    @NotNull(message = "El código del empleado no puede ser null")
    private String codEmpleado;

    @Schema(description = "Nombre del empleado")
    @NotNull(message = "El nombre del empleado no puede ser null")
    @Size(min = 3, max = 50, message
            = "El nombre debe ser entre 3 y 50 caracteres")
    private String nombreEmpleado;

    @Schema(description = "Fecha de inicio de trabajo")
    @PastOrPresent
    private Date fechaInicio;

    @Schema(description = "Fecha de baja de trabajo")
    @PastOrPresent
    private Date fechaBaja;

    @Schema(description = "Código de la oficina asociada")
    @Positive(message = "Si no tiene oficina, el valor debe ser null")
    private int office;

    @Schema(description = "Categoría de empleado, puede ser GN, GE o CO")
    @NotNull(message = "La categoría del empleado no puede ser null")
    private String categoria;
}
