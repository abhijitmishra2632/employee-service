package com.cosmos.controller;

import com.cosmos.model.Employee;
import com.cosmos.pojo.Employees;
import com.cosmos.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public Employees getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId){
        return employeeService.getEmployeeById(empId);
    }
    @GetMapping("/adddummy")
    public Employee saveDummyEmployee(){
        return employeeService.saveDummyEmployee();
    }
    @GetMapping("/filterdept/{deptId}")
    public Employees getEmployeeByDepartmentId(@PathVariable Long deptId){
        return employeeService.getEmployeeByDepartmentId(deptId);
    }
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
}
