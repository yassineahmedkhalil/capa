package com.capaboard.capa.controller;

import com.capaboard.capa.entities.Employee;
import com.capaboard.capa.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeByEmployeeId(id);
    }

    @GetMapping("/getEmployeeByFirstName/{firstName}")
    public List<Employee> getEmployeeByFirstName(@PathVariable("firstName") String firstName){
        return employeeService.findEmployeeByFirstName(firstName);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable Long id ,@RequestBody Employee employee){

        employeeService.updateEmployee(employee,id);
    }
}