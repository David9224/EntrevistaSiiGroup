package com.siigroup.david.impl;

import com.siigroup.david.model.Employee;
import com.siigroup.david.wrapper.ResponseWrapperEmployee;
import com.siigroup.david.wrapper.ResponseWrapperListEmployees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;
    private final String URI = "https://dummy.restapiexample.com/api/v1/";
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployees() {
        testRestTemplate = new TestRestTemplate();
        ResponseWrapperListEmployees responseWrapperListEmployees = testRestTemplate
                .getForObject(this.URI + "/employees", ResponseWrapperListEmployees.class);

        List<Employee> employeeList = this.employeeServiceImpl.getEmployees();
        assertEquals(employeeList, responseWrapperListEmployees.getData());
    }

    @Test
    void getEmployee() {
        Integer id = 1;
        testRestTemplate = new TestRestTemplate();
        ResponseWrapperEmployee responseWrapperEmployee = testRestTemplate
                .getForObject(this.URI + "/employee/" + id, ResponseWrapperEmployee.class);

        Employee employee = this.employeeServiceImpl.getEmployee(id);
        assertEquals(employee, responseWrapperEmployee.getData());
    }
}