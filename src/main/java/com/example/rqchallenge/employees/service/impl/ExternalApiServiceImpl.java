package com.example.rqchallenge.employees.service.impl;

import com.example.rqchallenge.employees.constant.RqChallengeConstants;
import com.example.rqchallenge.employees.model.response.ExternalApiCreateResponse;
import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.model.response.ExternalApiResponse;
import com.example.rqchallenge.employees.service.IExternalApiService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ExternalApiServiceImpl implements IExternalApiService {

    RestTemplate restTemplate;

    public ExternalApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Method to call Dummy API resource to get list of all employees
     */
    public List<Employee> callDummyApiTogetAllEmployees() {
        ExternalApiResponse responseObj = restTemplate.getForObject(
                RqChallengeConstants.GET_ALL_EMPLOYEE_LIST, ExternalApiResponse.class);
        return Arrays.asList(responseObj.getData());
    }

    /**
     * Method to call Dummy API resource to get employee details for passed employee id
     */

    public Employee callDummyApitoGetEmployeebyId(Integer employeeId){
        ExternalApiCreateResponse responseObj = new ExternalApiCreateResponse();
                responseObj = restTemplate.getForObject(
                RqChallengeConstants.GET_EMPLOYEE_BY_ID, ExternalApiCreateResponse.class,employeeId);
        return responseObj.getData();
    }

    /**
     * Method to call Dummy API resource to delete employee
     */

    public void callDummyApitoDeleteEmployee(String employeeId){
        restTemplate.delete(RqChallengeConstants.DELETE_EMPLOYEE,employeeId);
    }

    /**
     * Method to call Dummy API resource to create an employee
     */
    public Employee callDummyApiToCreateEmployee(Employee employeeInput) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("name", employeeInput.getEmployee_name());
        map.add("salary", employeeInput.getEmployee_salary().toString());
        map.add("age", employeeInput.getEmployee_age().toString());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ExternalApiCreateResponse responseObj = restTemplate.postForObject(RqChallengeConstants.CREATE_EMPLOYEE, request , ExternalApiCreateResponse.class );

        return responseObj.getData();
    }
}
