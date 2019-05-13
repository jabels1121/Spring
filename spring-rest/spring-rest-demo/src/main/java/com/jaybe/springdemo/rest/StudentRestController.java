package com.jaybe.springdemo.rest;

import com.jaybe.springdemo.exception.StudentNotFoundException;
import com.jaybe.springdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    private Logger logger = Logger.getLogger(getClass().getSimpleName());

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Alex", "Black"));
        students.add(new Student("John", "White"));
        students.add(new Student("Susan", "Blue"));
        students.add(new Student("Kim", "Kardashyan"));
        students.add(new Student("George", "Genetsavle"));
        logger.info(">>>>>> @PostConstruct method called");
    }

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        Stream<Student> stream = students.stream();
        return stream.peek(student -> {
                    student.setFirstName(student.getFirstName().toUpperCase());
                    student.setLastName(student.getLastName().toUpperCase());
                }).collect(Collectors.toList());
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Not found student with id " + studentId);
        }
        return students.get(studentId);
    }
}
