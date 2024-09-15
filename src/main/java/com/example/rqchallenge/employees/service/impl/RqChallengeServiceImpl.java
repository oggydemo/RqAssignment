package com.example.rqchallenge.employees.service.impl;

import com.example.rqchallenge.employees.constant.RqChallengeConstants;
import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.service.IExternalApiService;
import com.example.rqchallenge.employees.service.IRqChallengeService;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RqChallengeServiceImpl implements IRqChallengeService {

    private IExternalApiService externalApiService;

    public RqChallengeServiceImpl(IExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    /**
     * Method to get list of all employees
     */
    public List<Employee> getAllEmployee() {
        return externalApiService.callDummyApiTogetAllEmployees();
    }

    /**
     * Method to filter list of all employees matching search or containing give search name
     */

    public List<Employee> getEmployeesByNameSearch(String matchToName) {

        List<Employee> totalEmployees = externalApiService.callDummyApiTogetAllEmployees();
        return totalEmployees.stream()
                .filter(line -> line.getEmployee_name().contains(matchToName))
                .collect(Collectors.toList());
    }

    /**
     * Method to get employee matching to given employee id
     */

    public Employee getEmployeesById(Integer id) {
        return externalApiService.callDummyApitoGetEmployeebyId(id);
    }

    /**
     * Method return a single integer indicating the highest salary of all employees
     */

    public Integer getHighestSalaryOfEmployees() {

        Integer highestSaraly = 0;
        List<Employee> totalEmployees = externalApiService.callDummyApiTogetAllEmployees();

        List<Employee> sortedbySalaryEmployees = totalEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getEmployee_salary).reversed()).collect(Collectors.toList());
        highestSaraly = sortedbySalaryEmployees.get(0).getEmployee_salary();
        return highestSaraly;
    }

    /**
     * Method return a list of the top 10 employees based off of their salaries
     */

    public List<String> getTopTenHighestEarningEmployeeNames() {
        List<Employee> totalEmployees = externalApiService.callDummyApiTogetAllEmployees();
        List<Employee> topTenEmployees = totalEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getEmployee_salary).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return topTenEmployees.stream()
                .map(Employee::getEmployee_name)
                .collect(Collectors.toList());

    }

    /**
     * @param employeeInput
     */

    public String createEmployee(Employee employeeInput) {

        String response = "";
        Employee employee = null;

        employee = externalApiService.callDummyApiToCreateEmployee(employeeInput);

        if(employee.getId() != null){
            StringBuilder responseBuilder = new StringBuilder(RqChallengeConstants.EMPLOYEE_CREATED_SUCCESS);
            responseBuilder.append(" for ").append(employee.getId());
            response =  responseBuilder.toString();
        } else {
            response = RqChallengeConstants.EMPLOYEE_CREATED_FAILED;
        }

        return response;

    }

    /**
     * Method to remove employee
     */

    public String deleteEmployeeById(String id) {
        String employeeName = "";
        String response = "";
        List<Employee> employees = externalApiService.callDummyApiTogetAllEmployees();
        //get employee name
        Optional<Employee> matchedEmployeeById = employees.stream().
                filter(p -> p.getId() == Integer.parseInt(id)).findAny();
        if(matchedEmployeeById.isPresent()){
            employeeName = matchedEmployeeById.get().getEmployee_name();
            //call delete API
            externalApiService.callDummyApitoDeleteEmployee(id);
            StringBuilder responseBuilder = new StringBuilder(RqChallengeConstants.EMPLOYEE_DELETE_SUCCESS);
            responseBuilder.append(" for ").append(employeeName);
            response = responseBuilder.toString();
        } else {
            response = RqChallengeConstants.EMPLOYEE_DELETE_FAILED;
        }
        return response;
    }


}
