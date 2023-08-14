package com.siigroup.david.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.siigroup.david.model.Employee;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseWrapperEmployee {

    private String status;
    private Employee data;
    private String message;
}
