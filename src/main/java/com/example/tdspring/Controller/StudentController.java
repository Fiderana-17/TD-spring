package com.example.tdspring.Controller;

import com.example.tdspring.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class StudentController {

        @GetMapping("/welcome")
        public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {

            if (name == null || name.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Name is required");
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Welcome " + name);
        }

        // B) POST /students
        @PostMapping("/students")
        public ResponseEntity<?> addStudents(@RequestBody List<Student> newStudents) {

            try {
                students.addAll(newStudents);

                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(students);

            } catch (Exception e) {

                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Server error");
            }
        }
    }

