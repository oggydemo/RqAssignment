package com.example.rqchallenge;

import com.example.rqchallenge.employees.controller.impl.EmployeeController;
import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.service.IRqChallengeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController controller;

    @Mock
    private IRqChallengeService rqChallengeService;

    @Test
    void test_getAllEmployee() throws IOException
    {
        List<Employee> employeesMock = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmployee_salary(10000);
        emp.setEmployee_name("test");
        emp.setEmployee_age(25);
        employeesMock.add(emp);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.getAllEmployee()).thenReturn(employeesMock);
        ResponseEntity<List<Employee>>  responseEntity = controller.getAllEmployees();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
     void test_getEmployeesByNameSearch()
    {
        List<Employee> employeesMock = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setEmployee_salary(100000);
        emp1.setEmployee_name("test");
        emp1.setEmployee_age(25);

        Employee emp2 = new Employee();
        emp2.setEmployee_salary(408888);
        emp2.setEmployee_name("dummy");
        emp2.setEmployee_age(23);

        employeesMock.add(emp1);
        employeesMock.add(emp2);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.getEmployeesByNameSearch("test")).thenReturn(employeesMock);
        ResponseEntity<List<Employee>>  responseEntity = controller.getEmployeesByNameSearch("test");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
     void test_getEmployeeById()
    {
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setEmployee_salary(100000);
        emp1.setEmployee_name("test");
        emp1.setEmployee_age(25);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.getEmployeesById(1)).thenReturn(emp1);
        ResponseEntity<Employee>  responseEntity = controller.getEmployeeById("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void test_getHighestSalaryOfEmployees()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.getHighestSalaryOfEmployees()).thenReturn(10000);
        ResponseEntity<Integer>  responseEntity = controller.getHighestSalaryOfEmployees();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void test_getTopTenHighestEarningEmployeeNames()
    {
        List<String> employeeNames = new ArrayList<>();
        employeeNames.add("test1");
        employeeNames.add("test2");
        employeeNames.add("test3");
        employeeNames.add("test4");
        employeeNames.add("test5");
        employeeNames.add("test6");
        employeeNames.add("test7");
        employeeNames.add("test8");
        employeeNames.add("test9");
        employeeNames.add("test10");

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.getTopTenHighestEarningEmployeeNames()).thenReturn(employeeNames);
        ResponseEntity<List<String>>  responseEntity = controller.getTopTenHighestEarningEmployeeNames();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void test_createEmployee()
    {
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setEmployee_salary(100000);
        emp1.setEmployee_name("test");
        emp1.setEmployee_age(25);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.createEmployee(emp1)).thenReturn("Employee created successfully with id : 787");
        ResponseEntity<String>  responseEntity = controller.createEmployee(emp1);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void test_deleteEmployeeById()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(rqChallengeService.deleteEmployeeById("1")).thenReturn("successfully! deleted Record for 1");
        ResponseEntity<String>  responseEntity = controller.deleteEmployeeById("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
