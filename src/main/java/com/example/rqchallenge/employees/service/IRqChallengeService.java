package com.example.rqchallenge.employees.service;

import com.example.rqchallenge.employees.model.Employee;
import java.util.List;

public interface IRqChallengeService {
    public List<Employee> getAllEmployee();
    public List<Employee> getEmployeesByNameSearch(String matchToName);
    public Employee getEmployeesById(Integer id);
    public Integer getHighestSalaryOfEmployees();
    public List<String> getTopTenHighestEarningEmployeeNames();
    public String createEmployee(Employee employeeInput);
    public String deleteEmployeeById(String id);

}
