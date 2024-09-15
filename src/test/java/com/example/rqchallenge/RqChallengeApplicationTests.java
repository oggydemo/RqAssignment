package com.example.rqchallenge;

import com.example.rqchallenge.employees.config.RestTemplateConfig;
import com.example.rqchallenge.employees.controller.impl.EmployeeController;
import com.example.rqchallenge.employees.exception.RqChallengeException;
import com.example.rqchallenge.employees.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RqChallengeApplicationTests {

    @Autowired
    private EmployeeController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateConfig restTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void getEmployeeById_exceptionTest() throws Exception {
        Throwable thrown = assertThrows(RqChallengeException.class, () ->
                this.restTemplate.restTemplate()
                        .getForObject("http://localhost:" + port + "/test" + 2,
                                Employee.class)
        );
    }

    @Test
    void getHighestSalaryOfEmployees_exceptionTest() throws Exception {
        Throwable thrown = assertThrows(RqChallengeException.class, () ->
                this.restTemplate.restTemplate()
                        .getForObject("http://localhost:" + port + "/highestSalaryIncorrect",
                                Integer.class)
        );
    }

    @Test
    void getEmployeesByNameSearch_exceptionTest() throws Exception {
        Throwable thrown = assertThrows(RqChallengeException.class, () ->
                this.restTemplate.restTemplate()
                        .getForObject("http://localhost:" + port + "/searchTest/Ronald",
                                ResponseEntity.class)
        );
    }

    @Test
    void getTopTenHighestEarningEmployeeNames_exceptionTest() throws Exception {
        Throwable thrown = assertThrows(RqChallengeException.class, () ->
                this.restTemplate.restTemplate()
                        .getForObject("http://localhost:" + port + "/11topTenHighestEarningEmployeeNames",
                                ResponseEntity.class)
        );
    }

    @Test
    void deleteEmployeeById_exceptionTest() throws Exception {
        Throwable thrown = assertThrows(RqChallengeException.class, () ->
                this.restTemplate.restTemplate()
                        .delete("http://localhost:" + port + "/delete" + 2,
                                String.class)
        );
    }
}
