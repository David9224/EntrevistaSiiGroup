package com.siigroup.david.impl;

import com.siigroup.david.model.Employee;
import com.siigroup.david.wrapper.ResponseWrapperListEmployees;
import com.siigroup.david.service.EmployeeService;
import com.siigroup.david.wrapper.ResponseWrapperEmployee;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final String URI = "https://dummy.restapiexample.com/api/v1/";

    @Override
    public List<Employee> getEmployees() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapperListEmployees employees = restTemplate.getForObject(this.URI + "employees",
                ResponseWrapperListEmployees.class);

        return employees.getData()
                .stream()
                .map(employeeMap -> {
                    employeeMap.setEmployeeAnualSalary(
                            this.setEmployeeAnualSalary(employeeMap.getEmployeeSalary()));
                    return employeeMap;
                })
                .toList();

    }

    @Override
    public Employee getEmployee(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseWrapperEmployee employee = restTemplate.getForObject(this.URI + "employee/" + id,
                ResponseWrapperEmployee.class);
        Employee employeeAnswer = employee.getData();
        employeeAnswer.setEmployeeAnualSalary(
                this.setEmployeeAnualSalary(employeeAnswer.getEmployeeSalary()));
        return employeeAnswer;
    }

    private Long setEmployeeAnualSalary(Long employeeSalary){
        return employeeSalary * 12;
    }
}
