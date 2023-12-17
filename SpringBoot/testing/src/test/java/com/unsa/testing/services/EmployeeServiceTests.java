package com.unsa.testing.services;

import com.unsa.testing.application.services.EmployeeService;
import com.unsa.testing.application.services.EmployeeServiceImpl;
import com.unsa.testing.domain.repositories.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Test
    @DisplayName("Save Employee using Service")
    void saveEmployeeTest() {
        
    }
}
