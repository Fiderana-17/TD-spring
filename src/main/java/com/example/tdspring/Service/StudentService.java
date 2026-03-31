package com.example.tdspring.Service;

import com.example.tdspring.Entity.Student;
import com.example.tdspring.Validator.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    private StudentValidator validator = new StudentValidator();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentValidator getValidator() {
        return validator;
    }

    public void setValidator(StudentValidator validator) {
        this.validator = validator;
    }

    public List<Student> addStudents(List<Student> newStudents) {

        for (Student s : newStudents) {
            validator.validate(s);
        }

        students.addAll(newStudents);

        return students;
    }

}
