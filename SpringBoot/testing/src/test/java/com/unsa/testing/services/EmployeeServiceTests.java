package com.unsa.testing.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
}
