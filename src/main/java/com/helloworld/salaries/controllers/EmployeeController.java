package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.company.salary.services.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employee/{employeeCode}/salary/{year}")
    @Operation(summary = "Recupera un lista (12 valores) con el salario mensual del empleado indicado")
    public ResponseEntity<List<Double>> getAnualSalaryFromEmployee(@PathVariable String employeeCode, @PathVariable int year) {
        List<Double> salaries = employeeService.getMonthlySalariesForEmployee(employeeCode, year);
        return ResponseEntity.ok(salaries);
    }

}
