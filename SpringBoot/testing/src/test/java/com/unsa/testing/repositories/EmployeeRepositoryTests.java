package com.unsa.testing.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.unsa.testing.domain.entities.Employee;
import com.unsa.testing.domain.repositories.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTests {
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
}
