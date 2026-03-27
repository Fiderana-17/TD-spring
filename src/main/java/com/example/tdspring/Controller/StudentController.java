package com.example.tdspring.Controller;

import com.example.tdspring.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    public class StudentController {

    private List<Student> students = new ArrayList<>();

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

        @PostMapping(value = "/students", produces = "application/json")
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

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String accept) {

        try {

            if (accept == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Accept header is required");
            }

            if (!accept.equals("text/plain") && !accept.equals("application/json")) {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format not supported");
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(students);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Server error");
        }
    }
}

