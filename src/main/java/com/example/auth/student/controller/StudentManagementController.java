package com.example.auth.student.controller;

import com.example.auth.student.entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMINTRAINEE')")
    public List<Student> getSTUDENTS(){
        System.out.println("getSTUDENTS:");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("registerNewStudent:");
        System.out.println(student);
    }

    @DeleteMapping("/{studentID}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentID){
        System.out.println("deleteStudent:");
        System.out.println(studentID);
    }

    @PutMapping("/{studentID}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentID, @RequestBody Student student){
        System.out.println("updateStudent:");
        System.out.println(String.format("%s %s", studentID, student));
    }

}
