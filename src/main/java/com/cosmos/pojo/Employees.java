package com.cosmos.pojo;

import com.cosmos.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private List<Employee> employeeList;
}
