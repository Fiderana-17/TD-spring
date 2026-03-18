package com.example.tdspring.Controller;

import org.springframework.web.bind.annotation.*;

    @RestController
    public class StudentController {

        @GetMapping("/welcome")
        public String welcome(@RequestParam String name) {
            return "Welcome " + name;
        }

    }

