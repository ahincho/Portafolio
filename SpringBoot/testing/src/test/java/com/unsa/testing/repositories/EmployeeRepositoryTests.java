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
import java.util.Optional;

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
    @Test
    @DisplayName("Recover Employee by Id Test")
    void findEmployeeByIdTest() {
        // Given: Employee saved on Database
        employeeRepository.save(employee);
        // When: Recover employee from Database
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        // Then: Verify fields and id
        assertThat(savedEmployee).isNotNull();
    }
    @Test
    @DisplayName("Update Employee on Database Test")
    void updateEmployeeTest() {
        // Given: Employee saved on Database
        employeeRepository.save(employee);
        // When: Recover from Database then update fields
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setName("Eduardo");
        savedEmployee.setLastname("Jove");
        savedEmployee.setEmail("angelhincho@gmail.com");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);
        // Then: Recover fields of the updated employee
        assertThat(updatedEmployee.getId()).isEqualTo(savedEmployee.getId());
        assertThat(updatedEmployee.getName()).isEqualTo("Eduardo");
        assertThat(updatedEmployee.getLastname()).isEqualTo("Jove");
        assertThat(updatedEmployee.getEmail()).isEqualTo("angelhincho@gmail.com");
    }
    @Test
    @DisplayName("Delete Employee on Database Test")
    void deleteEmployeeTest() {
        // Given: Employee saved on Database
        employeeRepository.save(employee);
        // When: Delete the employee from Database
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> deletedEmployee = employeeRepository.findById(employee.getId());
        assertThat(deletedEmployee).isEmpty();
    }
}
