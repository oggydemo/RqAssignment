package com.example.rqchallenge.employees.model.response;

import com.example.rqchallenge.employees.model.Employee;
import java.io.Serializable;

public class ExternalApiCreateResponse implements Serializable {

    private String status;
    private Employee data;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }
}
