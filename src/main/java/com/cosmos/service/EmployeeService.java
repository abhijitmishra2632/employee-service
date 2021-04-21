package com.cosmos.service;

import com.cosmos.model.Employee;
import com.cosmos.pojo.Employees;
import com.cosmos.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employees getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        Employees employees = new Employees();
        employees.setEmployeeList(employeeList);
        return employees;
    }

    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    public Employee saveDummyEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Dummy Mishra");
        employee.setDeptId(2L);
        employee.setEmpJdate(LocalDate.now());
        employee.setEmpSalary(45000L);
        employee.setEmpDob(LocalDate.of(1989,11,2));
        return employeeRepository.save(employee);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employees getEmployeeByDepartmentId(Long deptId) {
        log.info("getEmployeeByDepartmentId called for"+deptId);
        Employees employees = new Employees();
        employees.setEmployeeList(employeeRepository.findByDeptId(deptId));
        return employees;
    }
}
