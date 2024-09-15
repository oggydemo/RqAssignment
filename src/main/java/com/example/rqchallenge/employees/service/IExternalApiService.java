package com.example.rqchallenge.employees.service;


import com.example.rqchallenge.employees.model.Employee;

import java.util.List;

public interface IExternalApiService {

    public List<Employee> callDummyApiTogetAllEmployees();
    public Employee callDummyApiToCreateEmployee(Employee employeeInput);
    public Employee callDummyApitoGetEmployeebyId(Integer employeeId);
    public void callDummyApitoDeleteEmployee(String employeeId);

}
