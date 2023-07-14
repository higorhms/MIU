package com.example.controller;

import com.example.entities.Student;
import com.example.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<Student> getAll(){
        return this.studentsService.getAll();
    }

    @GetMapping("/gpa")
    public List<Student> getByGPA(@RequestParam("gpa") int gpa) {
        return studentsService.getByGPA(gpa);
    }

    @GetMapping("/qualified")
    public List<Student> getQualifiedForGraduation() {
        return studentsService.getQualifiedForGraduation();
    }

    @GetMapping("/criteria")
    public List<Student> getByGpaAndHaveABookWithMoreThanPages(
            @RequestParam("gpa") int gpa,
            @RequestParam("numberOfPages") int numberOfPages) {
        return studentsService.findAllStudentsWithGpaLessThanAndHaveABookWithMoreThanPages(gpa, numberOfPages);
    }
}
