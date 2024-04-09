package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Schema(description = "Código de oficina asociada")
    private int idOffice;

    @Schema(description = "Nombre de la oficina")
    private String nameOffice;

    @Schema(description = "Ciudad donde se ubica la oficina")
    private String city;

    @Schema(description = "Código postal donde se ubica la oficina")
    private String postalCode;

    @Schema(description = "Código del país donde se ubica la oficina")
    private String countryCode;

    @Schema(description = "Indica si la oficina es Central (1) o si no (0)")
    private int headquarter;

    @Schema(description = "Continente donde se ubica la oficina")
    private String continent;

    @Schema(description = "Código de la oficina regional a la que está asignada")
    private int codigoRegional;
}
