package com.example.rqchallenge.employees.controller.impl;

import com.example.rqchallenge.employees.IEmployeeController;
import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.service.IRqChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.*;

@RestController
public class EmployeeController implements IEmployeeController {

    // creating a logger
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IRqChallengeService rqChallengeService;


    /**
     * Endpoint API to return list of all employees
     */
    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
        logger.info("Received request for endpoint 'getAllEmployees'");
        List<Employee> allEmployeesList = rqChallengeService.getAllEmployee();
        return new ResponseEntity<>(allEmployeesList,
                HttpStatus.OK);
    }

    /**
     * Endpoint API to return all employees whose name contains or matches the string input provided
     */
    @Override
    public ResponseEntity<List<Employee>> getEmployeesByNameSearch(String searchString) {
        logger.info("Received request for endpoint 'getEmployeesByNameSearch'");
        List<Employee> employeesByNameSearchList = rqChallengeService.getEmployeesByNameSearch(searchString);

        if(employeesByNameSearchList.size() > 0 ){
            return new ResponseEntity<>(employeesByNameSearchList,
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Endpoint API to return single employee matching id
     */
    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
        logger.info("Received request for endpoint 'getEmployeeById'");
        Integer employeeId = Integer.parseInt(id);
        Employee matchingEmployee = rqChallengeService.getEmployeesById(employeeId);
        if(matchingEmployee != null){
            return new ResponseEntity<>(matchingEmployee,
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
        logger.info("Received request for endpoint 'getHighestSalaryOfEmployees'");
        Integer highestPaidSalary = rqChallengeService.getHighestSalaryOfEmployees();
        return new ResponseEntity<>(highestPaidSalary,
                HttpStatus.OK);
    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
        logger.info("Received request for endpoint 'getTopTenHighestEarningEmployeeNames'");
        List<String> topTenEmplyeeNames = rqChallengeService.getTopTenHighestEarningEmployeeNames();
        return new ResponseEntity<>(topTenEmplyeeNames,
                HttpStatus.OK);
    }

    /**
     * @param employeeInput
     * @return
     */
    @Override
    public ResponseEntity<String> createEmployee(Employee employeeInput) {
        logger.info("Received request for endpoint 'createEmployee'");
        String response = rqChallengeService.createEmployee(employeeInput);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }

    /**
     * Enpoint to delete employee
     */
    @Override
    public ResponseEntity<String> deleteEmployeeById(String id) {
        logger.info("Received request for endpoint 'deleteEmployeeById'");
        String response = rqChallengeService.deleteEmployeeById(id);

        return new ResponseEntity<>(response.toString(),
                HttpStatus.OK);
    }
}
