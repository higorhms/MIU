package com.controller;

import com.entities.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
    private StudentService studentService;

    public StudentsController(@Autowired StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    public List<Student> getAll(){
        return this.studentService.getStudents();
    }

    @GetMapping(path = "/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return this.studentService.getStudent(studentId - 1);
    }
}
