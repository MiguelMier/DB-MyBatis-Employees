package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Schema(description = "Código de oficina asociada")
    @NotNull(message = "El id de oficina no puede ser null")
    private int idOffice;

    @Schema(description = "Nombre de la oficina")
    @NotNull(message = "El nombre de oficina no puede ser null")
    private String nameOffice;

    @Schema(description = "Ciudad donde se ubica la oficina")
    @NotNull(message = "La ciudad de la oficina no puede ser null")
    private String city;

    @Schema(description = "Código postal donde se ubica la oficina")
    @NotNull(message = "El código postal de la oficina no puede ser null")
    @Min(value = 1)
    @Max(value = 99999)
    private String postalCode;

    @Schema(description = "Código del país donde se ubica la oficina")
    @NotNull(message = "El código del país de la oficina no puede ser null")
    private String countryCode;

    @Schema(description = "Indica si la oficina es Central (1) o si no (0)")
    @NotNull(message = "Si no es headquarter, debe de ser 0, no null")
    @Min(value = 0)
    @Max(value = 1)
    private int headquarter;

    @Schema(description = "Continente donde se ubica la oficina")
    private String continent;

    @Schema(description = "Código de la oficina regional a la que está asignada")
    private int codigoRegional;
}
