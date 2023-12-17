package com.unsa.testing.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.unsa.testing.domain.entities.Employee;
import com.unsa.testing.domain.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTests {
    private Employee employee;
    @BeforeEach
    void setup() {
        System.out.println("Test started!");
        employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
    }
    @Autowired
    private EmployeeRepository employeeRepository;
    // Given: Precondition or configuration
    // When: Action or behaviour to tests
    // Then: Verify the output
    @Test
    @DisplayName("Save Employee on Database Test")
    void saveEmployeeTest() {
        // Given: Employee
        Employee employee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        // When: Save Entity
        Employee savedEmployee = employeeRepository.save(employee);
        // Then: Verify the id field
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0L);
    }
    @Test
    @DisplayName("List Employees on Database Test")
    void listEmployeesTest() {
        // Given: Employees saved on Database
        Employee anotherEmployee = Employee.builder()
                .name("Angel")
                .lastname("Hincho")
                .email("ahincho@unsa.edu.pe")
                .build();
        employeeRepository.save(employee);
        employeeRepository.save(anotherEmployee);
        // When: Recover employees from Database
        List<Employee> employees = employeeRepository.findAll();
        // Then: Verify records on Database
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(2);
    }
}
