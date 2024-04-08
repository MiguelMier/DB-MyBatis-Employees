package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final AvgSalaryService avgSalaryService;

    public CompanyController(AvgSalaryService avgSalaryService) {
        this.avgSalaryService = avgSalaryService;
    }

    @GetMapping("/salary/{year}/avg")
    public ResponseEntity<?> getAvgSalary(@PathVariable int year) {
        Double avgSalary = null;
        try {
            avgSalary = this.avgSalaryService.getAvgSalary(year);
            return ResponseEntity.ok(avgSalary);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /**
    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees = this.avgSalaryService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }*/

}
