package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Schema(description = "Código del salario")
    @NotNull(message = "El id de salario no puede ser null")
    private int salaryId;

    @Schema(description = "Código del empleado asociado")
    private String codEmpleado;

    @Schema(description = "Coste por hora")
    @Min(value = 1)
    @Max(value = 99999, message = "No puede ser mayor, la empresa se va a la quiebra")
    private double costeHora;

    @Schema(description = "Nombre del empleado asociado")
    @Size(min = 3, max = 50, message
            = "El nombre debe ser entre 3 y 50 caracteres")
    private String nombreEmpleado;

    @Schema(description = "Salario mensual")
    @Min(value = 33, message = "No puede ser menor del salario mínimo")
    @Max(value = 99999, message = "No puede ser mayor, la empresa se va a la quiebra")
    private double salary;

    @Schema(description = "Mes del salario")
    private int salaryMonth;

    @Schema(description = "Año del salario")
    private int salaryYear;
}
