package com.unsa.testing.infrastructure;

import com.unsa.testing.application.services.EmployeeService;
import com.unsa.testing.domain.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @GetMapping
    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.getEmployeeById(id)
                .map(savedEmployee -> {
                    savedEmployee.setName(employee.getName());
                    savedEmployee.setLastname(employee.getLastname());
                    savedEmployee.setEmail(employee.getEmail());
                    Employee updatedEmployee = employeeService.updateEmployee(savedEmployee);
                    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee was deleted", HttpStatus.NOT_FOUND);
    }
}
