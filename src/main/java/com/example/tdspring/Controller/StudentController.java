package com.example.tdspring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    }

