package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.company.salary.services.impl.EmployeeServiceImpl;
import com.helloworld.salaries.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name="EmployeeController", description = "Endpoints relacionados con empleados (/employee)")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Recupera un lista (12 valores) con el salario mensual del empleado indicado",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Devuelve el salario anual del empleado"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "No encuentra el empleado correctamente"
                    )
            })
    @Parameter(in = ParameterIn.PATH, name = "employeeCode",
            required = true, description = "Código del empleado",
            allowEmptyValue = false
    )
    @Parameter(in = ParameterIn.PATH, name = "year",
            required = true, description = "Año del que queremos comprobar el salario",
            allowEmptyValue = false
    )
    public ResponseEntity<List<Double>> getAnualSalaryFromEmployee(@PathVariable String employeeCode, @PathVariable int year) {
        List<Double> salaries = employeeService.getMonthlySalariesForEmployee(employeeCode, year);
        return ResponseEntity.ok(salaries);
    }

    @PostMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Crea, si no existe, la lista de salario de los 12 meses para un empleado un año concreto",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Crea correctamente la lista de salarios"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "No encuentra el empleado correctamente"
                    )
            })
    @Parameter(in = ParameterIn.PATH, name = "employeeCode",
            required = true, description = "Código del empleado",
            allowEmptyValue = false
    )
    @Parameter(in = ParameterIn.PATH, name = "year",
            required = true, description = "Año del que queremos comprobar el salario",
            allowEmptyValue = false
    )
    public ResponseEntity<List<Double>> createSalaryList(@PathVariable String employeeCode, @PathVariable int year) {
        List<Double> salaries = employeeService.createSalaryList(employeeCode, year);
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    @Operation(summary = "Realiza una búsqueda paginada de empleados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Realiza la búsqueda correctamente"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "No encuentra el empleado"
                    )
            })
    @Parameter(in = ParameterIn.PATH, name = "employeeName",
            required = true, description = "Nombre del empleado",
            allowEmptyValue = false
    )
    @Parameter(in = ParameterIn.PATH, name = "employeeCode",
            required = true, description = "Código del empleado",
            allowEmptyValue = false
    )
    @Parameter(in = ParameterIn.PATH, name = "page",
            required = true, description = "Número de página que queremos ver, tiene por defecto el valor=1",
            allowEmptyValue = true
    )
    @Parameter(in = ParameterIn.PATH, name = "pageSize",
            required = true, description = "Tamaño de la página, tiene por defecto el valor=10",
            allowEmptyValue = true
    )
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam(value = "name", required = false) String employeeName,
            @RequestParam(value = "employeeCode", required = false) String employeeCode,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        int offset = (page - 1) * pageSize;
        List<Employee> employees = employeeService.searchEmployees(employeeName, employeeCode, pageSize, offset);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{employeeCode}/salary/{year}/month/{month}")
    @Operation(summary = "Actualiza el salario mensual de un empleado en un mes concreto",
            description = "Este endpoint permite actualizar el salario mensual de un empleado para un año y mes específicos.")
    public ResponseEntity<?> updateMonthlySalary(
            @PathVariable @Parameter(description = "Código del empleado", in = ParameterIn.PATH) String employeeCode,
            @PathVariable @Parameter(description = "Año", in = ParameterIn.PATH) int year,
            @PathVariable @Parameter(description = "Mes", in = ParameterIn.PATH) int month,
            @RequestParam @Parameter(description = "Nuevo salario", required = true) double salary) {

        int rowsAffected = employeeService.updateMonthlySalary(employeeCode, year, month, salary);
        if (rowsAffected > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
