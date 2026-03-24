package com.example.tdspring.Validator;

import com.example.tdspring.Entity.Student;
import com.example.tdspring.Exception.BadRequestException;

public class StudentValidator {
    public void validate(Student s) {

        if (s.getReference() == null || s.getReference().isBlank()) {
            throw new BadRequestException("Reference cannot be null or empty");
        }

        if (s.getFirstName() == null || s.getFirstName().isBlank()) {
            throw new BadRequestException("FirstName cannot be null or empty");
        }

        if (s.getLastName() == null || s.getLastName().isBlank()) {
            throw new BadRequestException("LastName cannot be null or empty");
        }
    }
}
