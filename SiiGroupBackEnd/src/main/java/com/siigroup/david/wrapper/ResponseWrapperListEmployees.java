package com.siigroup.david.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.siigroup.david.model.Employee;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseWrapperListEmployees {

    private String status;
    private List<Employee> data;
    private String message;
}
