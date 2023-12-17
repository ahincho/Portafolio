package com.unsa.testing.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import com.unsa.testing.application.services.EmployeeServiceImpl;
import com.unsa.testing.domain.entities.Employee;
import com.unsa.testing.domain.exceptions.EmployeeIsSavedException;
import com.unsa.testing.domain.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    private Employee employee;
    @BeforeEach
    void setup() {
        employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
    }
    @Test
    @DisplayName("Save Employee using Service")
    void saveEmployeeTest() {
        // Given: Non saved employee on Database
        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
        // Given: Save employee on Database
        given(employeeRepository.save(employee)).willReturn(employee);
        // When: Save employee using service
        Employee savedEmployee = employeeService.saveEmployee(employee);
        // Then: Check that employee was recorded on Database
        assertThat(savedEmployee).isNotNull();
    }
    @Test
    @DisplayName("Save Duplicated Employee using Service")
    void saveDuplicatedEmployeeTest() {
        // Given: Duplicated employee already recorded on Database
        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.of(employee));
        // When: Record the same employee on Database then throw Exception
        assertThrows(EmployeeIsSavedException.class, () -> {
            employeeService.saveEmployee(employee);
        });
        // Then: Verify previous employee is already recorded on Database
        verify(employeeRepository, never()).save(any(Employee.class));
    }
    @Test
    @DisplayName("Get All Employees using Service")
    void getAllEmployeesTest() {
        // Given: Employees recorded on Database
        Employee employee1 = Employee.builder()
                .id(2L)
                .name("Eduardo")
                .lastname("Jove")
                .email("angelhincho@gmail.com")
                .build();
        given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));
        // When: List All Employees recorded on Database
        List<Employee> employees = employeeService.getAllEmployees();
        // Then: Check the employees recorded previously
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("Get Employees From Empty Database Test")
    void getAllEmployeesFromEmptyDatabaseTest() {
        // Given: Employee to record and empty Database
        Employee employee1 = Employee.builder()
                .id(2L)
                .name("Eduardo")
                .lastname("Jove")
                .email("angelhincho@gmail.com")
                .build();
        given(employeeRepository.findAll()).willReturn(Collections.emptyList());
        // When: Get all employees from Database then record new employee
        List<Employee> employees = employeeService.getAllEmployees();
        // Then: Check if the employees list is empty
        assertThat(employees).isEmpty();
        assertThat(employees.size()).isEqualTo(0);
    }
    @Test
    @DisplayName("Get Employee By Id Test using Service")
    void getEmployeeByIdTest() {
        // Given: Recorded employee previously on Database
        Employee recordedEmployee = Employee.builder()
                .id(1L)
                .name("Eduardo")
                .lastname("Jove")
                .email("angelhincho@gmail.com")
                .build();
        given(employeeRepository.findById(1L)).willReturn(Optional.of(recordedEmployee));
        // When: Recover employee by id
        Employee savedEmployee = employeeService.getEmployeeById(recordedEmployee.getId()).get();
        // Then: Check and ask for recorded employee
        assertThat(savedEmployee).isNotNull();
    }
    @Test
    @DisplayName("Update Employee Test using Service")
    void updateEmployeeTest() {
        // Given: Recorded employee on Database
        given(employeeRepository.save(employee)).willReturn(employee);
        employee.setName("Angel Eduardo");
        employee.setLastname("Hincho Jove");
        employee.setEmail("angelhincho@unsa.edu.pe");
        // When: Update the recorded data of the employee
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        // Then: Check the fields after updating data
        assertThat(updatedEmployee.getName()).isEqualTo("Angel Eduardo");
        assertThat(updatedEmployee.getLastname()).isEqualTo("Hincho Jove");
        assertThat(updatedEmployee.getEmail()).isEqualTo("angelhincho@unsa.edu.pe");
    }
    @Test
    @DisplayName("Delete Employee Test using Service")
    void deleteEmployeeTest() {
        // Given: No saved employees on Database
        long employeeId = 1L;
        willDoNothing().given(employeeRepository).deleteById(employeeId);
        // When: Try to delete employee from Database
        employeeService.deleteEmployee(employeeId);
        // Then: Verify call to the delete by id operation
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }
}
