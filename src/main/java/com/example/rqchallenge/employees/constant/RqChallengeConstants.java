package com.example.rqchallenge.employees.constant;

public final class RqChallengeConstants {

    private RqChallengeConstants(){

    }

    public static String GET_ALL_EMPLOYEE_LIST = "https://dummy.restapiexample.com/api/v1/employees";
    public static String CREATE_EMPLOYEE = "https://dummy.restapiexample.com/api/v1/create";
    public static String DELETE_EMPLOYEE = "https://dummy.restapiexample.com/api/v1/delete/{id}";
    public static String GET_EMPLOYEE_BY_ID = "https://dummy.restapiexample.com/api/v1/employee/{id}";

    public static String RQ_CALLENGE_EXTERNAL_API_BUSY_ERROR = "External API Service is busy at the moment and can not process your request";
    public static String RQ_CALLENGE_EXTERNAL_API_SERVER_ERROR = "Internal error occurred at external API Service side";

    public static String EMPLOYEE_DELETE_SUCCESS = "successfully! deleted Record";
    public static String EMPLOYEE_DELETE_FAILED = "Unable to delete the record as employe id could not found";

    public static String EMPLOYEE_CREATED_SUCCESS= "Employee created successfully with id :";
    public static String EMPLOYEE_CREATED_FAILED = "Unable to create employee";
}
