package com.unsa.testing.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unsa.testing.application.services.EmployeeService;
import com.unsa.testing.domain.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @DisplayName("Save Employee from Rest Controller")
    void saveEmployeeTest() throws Exception {
        // Given: Employee and service ready to go
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocationOnMock) ->
                    invocationOnMock.getArgument(0)
                );
        // When: Try to save employee using rest controller
        ResultActions response = mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));
        // Then: Check the response entity
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(employee.getName())))
                .andExpect(jsonPath("$.lastname", is(employee.getLastname())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }
    @Test
    @DisplayName("Get All Employees from Rest Controller")
    void getAllEmployeesTest() throws Exception {
        // Given: Some employees saved on Database
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().name("Angel").lastname("Hincho").email("ahincho@unsa.edu.pe").build());
        employees.add(Employee.builder().name("Eduardo").lastname("Jove").email("ahincho@gmail.com").build());
        employees.add(Employee.builder().name("Fabiola").lastname("Tapara").email("ftapara@unsa.edu.pe").build());
        employees.add(Employee.builder().name("Grissel").lastname("Quispe").email("ftapara@gmail.com").build());
        given(employeeService.getAllEmployees()).willReturn(employees);
        // When: Recover all employees from rest controller
        ResultActions response = mockMvc.perform(get("/api/employee"));
        // Then: Verify the list of employees
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(employees.size())));
    }
    @Test
    @DisplayName("Get Employee By Id from Rest Controller")
    void getEmployeeById() throws Exception {
        // Given: Saved employee on Database
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));
        // When: Look for the saved employee
        ResultActions response = mockMvc.perform(get("/api/employee/{id}", employeeId));
        // Then: Check fields of the saved or recover employee
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(employee.getName())))
                .andExpect(jsonPath("$.lastname", is(employee.getLastname())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }
    @Test
    @DisplayName("Get No Register Employee By Id from Rest Controller")
    void getNoRegisterEmployeeTest() throws Exception {
        // Given: Saved employee on Database
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
        // When: Look for the saved employee
        ResultActions response = mockMvc.perform(get("/api/employee/{id}", employeeId));
        // Then: Check fields of the saved or recover employee
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    @DisplayName("Update Employee from Rest Controller")
    void updateEmployeeTest() throws Exception {
        // Given: Saved employee on Database
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        Employee updatedEmployee = Employee.builder()
                .name("Eduardo")
                .lastname("Jove")
                .email("angelhincho@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        // When: Try to update recorded employee from rest controller
        ResultActions response = mockMvc.perform(put("/api/employee/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));
        // Then: Check that fields were updated
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(updatedEmployee.getName())))
                .andExpect(jsonPath("$.lastname", is(updatedEmployee.getLastname())))
                .andExpect(jsonPath("$.email", is(updatedEmployee.getEmail())));
    }
    @Test
    @DisplayName("Update No Register Employee from Rest Controller")
    void updateNoRegisterEmployeeTest() throws Exception {
        // Given: No saved employee on Database
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        Employee updatedEmployee = Employee.builder()
                .name("Eduardo")
                .lastname("Jove")
                .email("angelhincho@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        // When: Try to update recorded employee from rest controller
        ResultActions response = mockMvc.perform(put("/api/employee/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));
        // Then: Check that employee was not found
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    @DisplayName("Delete Employee from Rest Controller")
    void deleteEmployeeTest() throws Exception {
        // Given: Saved employee on Database
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));
        willDoNothing().given(employeeService).deleteEmployee(employeeId);
        // When: Try to delete employee from rest controller
        ResultActions response = mockMvc.perform(delete("/api/employee/{id}", employeeId));
        // Then: Check that the employee was deleted
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
}
