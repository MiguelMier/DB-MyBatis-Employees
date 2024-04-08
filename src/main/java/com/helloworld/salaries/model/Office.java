package com.helloworld.salaries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    private int idOffice;
    private String nameOffice;
    private String city;
    private String postalCode;
    private String countryCode;
    private int headquarter;
    private String continent;
    private int codigoRegional;
}
