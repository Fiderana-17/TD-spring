package com.example.tdspring.Controller;

import com.example.tdspring.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


import java.util.List;
@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudents(@RequestBody List<Student> newStudents) {

        try {
            List<Student> result = service.addStudents(newStudents);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);

        } catch (BadRequestException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }
}