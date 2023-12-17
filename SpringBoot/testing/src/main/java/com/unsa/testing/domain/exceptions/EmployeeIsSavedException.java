package com.unsa.testing.domain.exceptions;

public class EmployeeIsSavedException extends RuntimeException {
    public EmployeeIsSavedException(String message) {
        super(message);
    }
}
