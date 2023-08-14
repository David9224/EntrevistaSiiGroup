package com.siigroup.david.service;

import com.siigroup.david.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployee(Integer id);
}
