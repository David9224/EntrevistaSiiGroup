package com.siigroup.david.controller;

import com.siigroup.david.model.Employee;
import com.siigroup.david.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController controller;
    @Mock
    private EmployeeService service;
    private ResponseEntity responseEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeesOk() {
        Mockito.when(service.getEmployees()).thenReturn(new ArrayList<Employee>());
        responseEntity = new ResponseEntity<>(new ArrayList<Employee>(), HttpStatus.OK);
        assertEquals(controller.getEmployees(), responseEntity);
    }

    @Test
    void getEmployees500() {
        Mockito.when(service.getEmployees()).thenThrow(new RuntimeException());
        assertThat(controller.getEmployees().getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void getEmployeeeByIdOk() {
        Integer id = 1;
        Mockito.when(service.getEmployee(id)).thenReturn(new Employee());
        responseEntity = new ResponseEntity<>(new Employee(), HttpStatus.OK);
        assertEquals(controller.getEmployeeeById(id), responseEntity);
    }

    @Test
    void getEmployeeeById500() {
        Mockito.when(service.getEmployee(1)).thenThrow(new RuntimeException());
        assertThat(controller.getEmployeeeById(1).getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}