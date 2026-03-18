package com.example.tdspring.Controller;

import com.example.tdspring.Entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class StudentController {

        private List<Student> students = new ArrayList<>();

        @GetMapping("/welcome")
        public String welcome(@RequestParam String name) {
            return "Welcome " + name;
        }

        @PostMapping("/students")
        public String addStudents(@RequestBody List<Student> newStudents) {

            students.addAll(newStudents);

            String result = "";
            for (Student s : students) {
                result += s.getFirstName() + " " + s.getLastName() + "\n";
            }

            return result;
        }

        @GetMapping("/students")
        public String getStudents(@RequestHeader(value = "Accept", defaultValue = "text/plain") String accept) {

            if (!accept.equals("text/plain")) {
                return "Format non supporté";
            }

            String result = "";
            for (Student s : students) {
                result += s.getFirstName() + " " + s.getLastName() + "\n";
            }

            return result;
        }
    }

