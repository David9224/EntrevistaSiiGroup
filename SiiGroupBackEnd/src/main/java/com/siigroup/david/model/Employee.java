package com.siigroup.david.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Employee {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("employee_salary")
    private Long employeeSalary;
    @JsonProperty("employee_age")
    private Integer employeeAge;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("employee_anual_salary")
    private Long employeeAnualSalary;
}
