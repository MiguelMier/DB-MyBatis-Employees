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

    @Schema(description = "Código del país donde se ubica la oficina",
            allowableValues = {"ES", "MX", "GU"})
    @NotNull(message = "El código del país de la oficina no puede ser null")
    private String countryCode;

    @Schema(
            description = "Indica si la oficina es Central o no",
            allowableValues = {"0", "1"},
            example = "1",
            $comment = "1 - Oficina central, 0 - Oficina regional común"
    )
    private int headquarter;

    @Schema(description = "Continente donde se ubica la oficina",
            allowableValues = {"Europa", "South America"},
            $comment = "Solamente válidos porque no hay oficinas en otros continentes"
    )
    private String continent;

    @Schema(description = "Código de la oficina regional a la que está asignada")
    private int codigoRegional;
}
